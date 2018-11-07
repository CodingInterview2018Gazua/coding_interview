package com.example.hoo.rxjava.baekjoon

import java.util.*

fun main(args: Array<String>) {
    val source = ArrayList<String>()
    val sc = Scanner(System.`in`)

    while (sc.hasNextLine()) {
        source.add(sc.nextLine())
    }

    val costumeSize = source[0].split(" ")[1].toInt()

    source.removeAt(0)

    val cows = source.map { it.toInt() }
    var pairs = 0

    for (i in 0 until cows.size) {
        for (j in i + 1 until cows.size) {
            if (cows[i] + cows[j] <= costumeSize)
                pairs++
        }
    }

    print(pairs)
}