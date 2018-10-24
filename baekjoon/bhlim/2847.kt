package com.example.hoo.rxjava

import java.util.*

fun main(args: Array<String>) {
    //val test = intArrayOf(5,3,7,5)

    val sc = Scanner(System.`in`)
    val array = ArrayList<Int>()

    while (sc.hasNext()) {
        array.add(sc.next().toInt())
    }

    array.removeAt(0)

    array.printMinusCount()
}

private fun ArrayList<Int>.printMinusCount() {
    var minusCount = 0

    forEachIndexed { idx, value ->
        if(idx == size -1)
            return@forEachIndexed

        if(value >= this[idx + 1]) {
            minusCount += value - this[idx + 1] + 1
        }
    }

    print(minusCount)
}