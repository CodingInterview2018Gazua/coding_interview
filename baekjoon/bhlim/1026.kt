package com.example.hoo.rxjava.baekjoon

import java.util.*

fun main(args: Array<String>) {
    val source = ArrayList<String>()
//    val sc = Scanner(System.`in`)
//
//    while (sc.hasNextLine()) {
//        source.add(sc.nextLine())
//    }
//
//    source.removeAt(0)


    source.add("1 1 1 6 0")
    source.add("2 7 8 3 1")

    var sum = 0

    val A = source[0].split(" ").map { it.toInt() }.toIntArray()
    val B = source[1].split(" ").map { it.toInt() }.toIntArray()

    print("${Arrays.toString(A)}\n${Arrays.toString(B)}")

    A.sortDescending()
    B.sort()

    for (i in 0 until A.size) {
        sum += A[i] * B[i]
    }

    print(sum)
}