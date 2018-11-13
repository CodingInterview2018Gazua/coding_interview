package com.example.hoo.rxjava.baekjoon

import java.util.*

fun main(args: Array<String>) {
    val source = ArrayList<String>()
    val sc = Scanner(System.`in`)

    while (sc.hasNextLine()) {
        source.add(sc.nextLine())
    }

    source.removeAt(0)

//    source.add("PPAP")
//    source.add("PPAPP")
//    source.add("PPPPA")
//    source.add("APPPP")
//    source.add("PPPAP")
//    source.add("PAPAP")

    val S = source[0]

    source.removeAt(0)

    source.forEach {
        sendMeTheMoney(S, it)
    }
}

private fun sendMeTheMoney(S : String, M : String) {
    var idx = 0

    for(j in 0 until M.length) {
        if(M[j] == S[idx])
            idx++

        if(idx == S.length) {
            print("true\n")
            return
        }
    }

    print("false\n")
}