package com.example.lib.backjoon

import java.util.*
import kotlin.collections.ArrayList

var count = 0
var maxSum = 0

fun main(args: Array<String>) {
//    val sc = Scanner(System.`in`)
//    val array = ArrayList<String>()
//
//    while (sc.hasNext()) {
//        array.add(sc.next())
//    }
//
//    array.removeAt(0)

    val coins = ArrayList<Int>()

//    for(i in 1 until 21) {
//        coins.add(i)
//    }

    coins.add(1)
    coins.add(2)

    maxSum = 100
    coins.getCoinSumCount(0, 0)

    print("$count\n")

//    var result = ""
//
//    array.forEachIndexed { index, inputStr ->
//        when (index % 3) {
//            1 -> {
//                coins.clear()
//                inputStr.split(" ").forEach {
//                    coins.add(it.toInt())
//                }
//            }
//            2 -> {
//                count = 0
//                maxSum = inputStr.toInt()
//                coins.getCoinSumCount(0, 0)
//                result += "$count\n"
//            }
//        }
//    }
//
//    print(result)
}

private fun MutableList<Int>.getCoinSumCount(sum : Int, idx : Int) {
    var innerSum = sum

    while (innerSum < maxSum) {
        if(idx < size - 1)
            getCoinSumCount(innerSum, idx + 1)

        innerSum += this[idx]
    }

    if(innerSum == maxSum)
        count++
}