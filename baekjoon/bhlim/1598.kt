package com.example.hoo.rxjava.baekjoon

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val input1 = sc.nextInt()
    val input2 = sc.nextInt()

//    val input1 = 15
//    val input2 = 12

    val pair1 = getPoint(input1)
    val pair2= getPoint(input2)

    print(Math.abs(pair1.first - pair2.first) + Math.abs(pair1.second - pair2.second))
}

private fun getPoint(input : Int) : Pair<Int, Int> {
    var X = input / 4

    if(input % 4 == 0)
        X--

    var Y = input % 4

    if(Y == 0)
        Y = 4

    return Pair(X, Y)
}