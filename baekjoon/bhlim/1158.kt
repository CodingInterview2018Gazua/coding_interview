package com.example.lib.backjoon

import java.util.*
import kotlin.collections.ArrayList


fun main(args: Array<String>) {
//    val sc = Scanner(System.`in`)
//    val array = ArrayList<String>()
//
//    while (sc.hasNext()) {
//        array.add(sc.next())
//    }

    //josephus(array[0].toInt(), array[1].toInt())
    josephus(7, 3)
}

fun josephus(N: Int, M: Int) {
    val arr = ArrayList<Int>()
    var varN = N

    for (i in 1 until N + 1)
        arr.add(i)

    var count = 0

    //print("arr = $arr\n")

    var result = "<"

    while (count != N) {
        if (arr.size == count && count != 0) {
            for (i in 0 until arr.size - 1)
                result += "${arr[i]}, "

            break
        } else {
            val item = arr[M - 1]

            //print("$item\n")

            result += "$item, "

            val arrTemp = arr.clone() as ArrayList<*>
            arr.clear()

            varN--

            for (i in M until varN + 1)
                arr.add(arrTemp[i] as Int)

            for (i in 0 until M)
                arr.add(arrTemp[i] as Int)


            //print("arr = $arr\n")
            count++
        }
    }

    print(result.substring(0, result.length - 2) + ">")
}

