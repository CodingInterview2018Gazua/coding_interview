package com.example.lib.backjoon

import java.util.*

var min = 0

fun main(args: Array<String>) {
//    val sc = Scanner(System.`in`)
//    val array = ArrayList<String>()
//
//    while (sc.hasNext()) {
//        array.add(sc.next())
//    }
//
//    //array.removeAt(0)
//
//    val intArray = ArrayList<Int>()
//
//    array[1].split(" ").forEach {
//        intArray.add(it.toInt())
//    }
//
//    intArray.run {
//        val newArr = ArrayList<Int>()
//
//        forEachIndexed { index, value ->
//            if (index < size - 1) {
//                if (value <= this.subList(index + 1, size).max() ?: 1000)
//                    newArr.add(value)
//            } else if (index == size - 1) {
//                if(newArr.max() ?: 1000 < value)
//                    newArr.add(value)
//            }
//        }
//
//        val result = ArrayList<Int>()
//        newArr.setIntList(result)
//
//        print(result.size)
//    }

    intArrayOf(10, 20, 60, 70, 30, 50).toCollection(ArrayList()).run {
        val result = ArrayList<Int>()
        setIntList(result, 0)

        print("$result\n")
        print(result.size)
    }

    // 1, 3, 5, 3, 1, 6, 2, 3, 4, 5
    // 10, 20, 10, 30, 20, 50
}

fun ArrayList<Int>.setIntList(result: ArrayList<Int>, startIdx : Int) {
    if(startIdx == size)
        return

    var endIdx = startIdx + 1

    for(i in startIdx until size) {
        if(i < size -1) {
            if(this[i] < this[i + 1]) {
                endIdx++
            } else {
                val tempArr = this.subList(startIdx, endIdx)
                tempArr.forEach {
                    if(!result.contains(it))
                        result.add(it)
                }
                min = result.last()
                break
            }
        } else if(i == size -1){
            if(result.max() ?: 1 < this[i])
                result.add(this[i])
        }
    }

    setIntList(result, startIdx + 1)
}