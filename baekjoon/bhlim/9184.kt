package com.example.hoo.rxjava.baekjoon

import java.util.*

private val dp = Array(21) { Array(21) { IntArray(21) { 0 } } }

fun main(args: Array<String>) {
    val source = ArrayList<String>()
    val sc = Scanner(System.`in`)

    while (sc.hasNextLine()) {
        source.add(sc.nextLine())
    }

//    source.add("1 1 1")
//    source.add("2 2 2")
//    source.add("21 21 21")
//    source.add("50 50 50")
//    source.add("-1 7 18")
//    source.add("-1 -1 -1")

    source.filter {
        it != "-1 -1 -1"
    }.map {
        it.split(" ").map { innerIt ->
            innerIt.toInt()
        }
    }.forEach {
        val a = it[0]
        val b = it[1]
        val c = it[2]

        print("w($a, $b, $c) = ${w(a, b, c)}\n")
    }
}

private fun w(a: Int, b: Int, c: Int): Int {
    return when {
        a <= 0 || b <= 0 || c <= 0 -> 1
        a > 20 || b > 20 || c > 20 -> {
            dp[20][20][20] = w(20, 20, 20)
            dp[20][20][20]
        }
        dp[a][b][c] != 0 -> dp[a][b][c]
        else -> {
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
            dp[a][b][c]
        }
    }
}