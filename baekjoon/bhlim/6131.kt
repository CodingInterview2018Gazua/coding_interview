package com.example.hoo.rxjava.baekjoon

import java.util.*

fun main(args: Array<String>) {
    val source = ArrayList<String>()
    val sc = Scanner(System.`in`)

    while (sc.hasNextLine()) {
        source.add(sc.nextLine())
    }

    val N = source[0].toInt()
    var count = 0

    for(A in 1 until 500) {
        for (B in A until 500) {
            if( A * A + N == B * B)
                count++
        }
    }

    print(count)
}