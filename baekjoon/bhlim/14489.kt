package com.example.hoo.rxjava.baekjoon

import java.util.*

private var A = 0L
private var B = 0L

private var chicken = 0L

fun main(args: Array<String>) {
    val source = ArrayList<String>()
    val sc = Scanner(System.`in`)

    while (sc.hasNextLine()) {
        source.add(sc.nextLine())
    }

//    source.add("87 31")
//    source.add("20000")

//    source.add("15000 6000")
//    source.add("5000")

//    source.add("1000000000 1000000000")
//    source.add("1000000001")

    source[0].split(" ").apply {
        A = this[0].toLong()
        B = this[1].toLong()
    }

    chicken = source[1].toLong()

    if (chicken * 2 <= A + B)
        print(A + B - chicken * 2)
    else
        print(A + B)
}