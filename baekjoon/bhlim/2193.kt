package com.example.hoo.rxjava.baekjoon

import java.util.*

private lateinit var result: Array<Int>
private var length = 0
private var resultCount = 0

fun main(args: Array<String>) {
//    val source = ArrayList<Int>()
//    val sc = Scanner(System.`in`)
//
//    while (sc.hasNextInt()) {
//        source.add(sc.nextInt())
//    }

    length = 5

    when (length) {
        1, 2 -> resultCount = 1
        else ->  {
            result = Array(length) { 0 }

            result[0] = 1
            result[1] = 0

            getFriendlyBinary(2)
        }
    }

    print(resultCount)
}

private fun getFriendlyBinary(index: Int) {
    if (index == length) {
        print("${Arrays.toString(result)}\n")
        resultCount++
        return
    }

    if (result[index - 1] == 0) {
        result[index] = 1
        getFriendlyBinary(index + 1)
    }

    result[index] = 0
    getFriendlyBinary(index + 1)
}