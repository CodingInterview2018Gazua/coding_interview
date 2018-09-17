package com.example.lib.backjoon

import java.util.*
import kotlin.collections.ArrayList

var sumList : ArrayList<Int> = ArrayList()

fun main(args: Array<String>) {
    //val sc = Scanner(System.`in`)
    val array = ArrayList<String>()

//    while (sc.hasNext()) {
//        array.add(sc.next())
//    }

    array.clear()
    array.add("2")
    array.add("5")
    array.add("1 2 3 4 5")
    array.add("5")
    array.add("2 1 -2 3 -5")

    var testCounter  = 0

    while (testCounter != array[0].toInt()) {
        val setArray = array[array.size -1 -testCounter * 2].split(" ")
        setArray.recc(0, setArray.size -1)
        print("${sumList.max()}\n")
        testCounter++
    }
}

fun List<String>.recc(startIdx : Int, sumSize : Int) {
    if(startIdx > this.size -1)
        return

    var sum = 0

    for(i in 0 until sumSize) {
        val idx = startIdx + i

        if(idx > this.size -1)
            break

        sum += this[idx].toInt()
    }

    sumList.add(sum)

    for(i in 0 until  this.size -1) {
        this.recc(startIdx + 1, i)
    }
}