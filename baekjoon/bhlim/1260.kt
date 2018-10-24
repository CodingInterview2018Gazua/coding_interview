package com.example.hoo.baekjoon

import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//fun main(args: Array<String>) {
//    val datas = HashMap<Int, ArrayList<Int>>()
//
//    var arr = ArrayList<Int>()
//
//    arr.add(2)
//    arr.add(5)
//
//    datas[1] = arr
//
//    ///////////
//
//    arr = ArrayList()
//
//    arr.add(1)
//    arr.add(3)
//    arr.add(4)
//    arr.add(5)
//
//    datas[2] = arr
//
//    ////////////
//
//    arr = ArrayList()
//
//    arr.add(2)
//    arr.add(4)
//
//    datas[3] = arr
//
//    ////////////
//
//    arr = ArrayList()
//
//    arr.add(3)
//    arr.add(5)
//    arr.add(2)
//    arr.add(6)
//
//    datas[4] = arr
//
//    ////////////
//
//    arr = ArrayList()
//
//    arr.add(1)
//    arr.add(2)
//    arr.add(4)
//
//    datas[5] = arr
//
//    ////////////
//
//    arr = ArrayList()
//
//    arr.add(4)
//
//    datas[6] = arr
//
//    datas.dfs(1)
//    datas.bfs(1)
//}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val array = ArrayList<String>()

    while (sc.hasNextLine()) {
        array.add(sc.nextLine())
    }

    val startLine = array[0]

    array.removeAt(0)

    val startIdx = (startLine.split(" "))[2].toInt()

    val datas = HashMap<Int, ArrayList<Int>>()

    array.forEach {
        val splited = it.split(" ")

        val start = splited[0].toInt()
        val dest = splited[1].toInt()

        val arr : ArrayList<Int>?

        if(datas.containsKey(start)) {
            arr = datas[start]

            if(arr?.contains(dest) == false) {
                arr.add(dest)
                datas[start] = arr
            }
        } else {
            arr = ArrayList()
            arr.add(dest)

            datas[start] = arr
        }
    }

    datas.dfs(startIdx)
    datas.bfs(startIdx)
}

private fun Map<Int, ArrayList<Int>>.dfs(start : Int) {
    val resultArr = ArrayList<Int>()
    val stack = Stack<Int>()

    resultArr.add(start)

    val destArr = get(start)

    if(destArr?.isNotEmpty() == true) {
        destArr.forEach {
            stack.push(it)

            while (stack.isNotEmpty()) {
                val pop = stack.pop()

                if(!resultArr.contains(pop))
                    resultArr.add(pop)

                val dests = this[pop]

                dests?.forEach {
                    if(!resultArr.contains(it) && !stack.contains(it))
                        stack.push(it)
                }
            }
        }

    }

    resultArr.print()
}

private fun Map<Int, ArrayList<Int>>.bfs(start : Int) {
    val resultArr = ArrayList<Int>()
    val queue = LinkedBlockingQueue<Int>()

    resultArr.add(start)

    val destArr = get(start)

    if(destArr?.isNotEmpty() == true) {
        destArr.forEach {
            if(!resultArr.contains(it))
                queue.add(it)
        }

        while (queue.isNotEmpty()) {
            val pop = queue.poll()

            if(!resultArr.contains(pop))
                resultArr.add(pop)

            val dests = this[pop]

            dests?.forEach {
                if(!resultArr.contains(it) && !queue.contains(it))
                    queue.add(it)
            }
        }

    }

    resultArr.print()
}

private fun ArrayList<Int>.print() {
    var result = ""

    forEach {
        result += "$it "
    }

    print("${result.substring(0, result.length -1)}\n")
}
