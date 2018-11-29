package com.example.hoo.rxjava.baekjoon

import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`).nextLine()

    //val input = "baekjoon"
    val result = HashMap<Char, Int>()

    for(char in 'a' until 'z' + 1 )
        result[char] = -1

    input.forEachIndexed { idx, char ->
        if(result[char] == -1)
            result[char] = idx
    }

    result.forEach {
        print("${it.value} ")
    }
}