package com.example.lib.backjoon

import java.util.*
import kotlin.collections.ArrayList


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val array = ArrayList<String>()

    while (sc.hasNext()) {
        array.add(sc.next())
    }

    array.removeAt(0)

    //val test = arrayOf("101e", "010010o", "1e" , "000e" , "110100101o" , "e", "o","#")

    array.printParity()
}

private fun ArrayList<String>.printParity() {
    this.forEach {
        if(it == "#")
            return@forEach
        else {
            println(it.calculateParity())
        }
    }

//    this.forEachIndexed { index, str ->
//        if(str == "#")
//            return@forEachIndexed
//        else {
//            print(str.calculateParity())
//
//            if(index != size - 2)
//                print("\n")
//        }
//    }
}

private fun String.calculateParity() : String {
    var count1 = 0
    val parity = this[length - 1]
    var newBitStr = substring(0, length -1)

    for(i in 0 until length -1) {
        if(this[i] == '1')
            count1++
    }

    when(parity) {
        'e' -> {
            newBitStr += if(count1 % 2 == 0) {
                "0"
            } else {
                "1"
            }
        }
        'o' -> {
            newBitStr += if(count1 % 2 == 0) {
                "1"
            } else {
                "0"
            }
        }
    }

    return newBitStr
}