package com.example.hoo.rxjava.baekjoon

import java.util.*
import kotlin.collections.ArrayList

val visited = ArrayList<Pair<Int,Int>>()

fun main(args: Array<String>) {

    val input = Array(5) { Array(6) { 0 } }

    input[0][1] = 1
    input[0][3] = 1
    input[0][5] = 1

    input[1][1] = 1

    input[2][1] = 1
    input[2][2] = 1
    input[2][3] = 1
    input[2][5] = 1

    input[3][0] = 1
    input[3][4] = 1
    input[3][5] = 1

    input[4][2] = 1
    input[4][4] = 1
    input[4][5] = 1

    input.findOut()
}

private fun Array<Array<Int>>.findOut() {
    val stack = Stack<Pair<Int,Int>>()

    for(i in 0 until this[0].size) {
        val visit = Pair(0, i)

        if(!visited.contains(visit) && this[visit.first][visit.second] == 1 ) {
            stack.push(visit)

            while (stack.isNotEmpty()) {
                val pop = stack.pop()
                visited.add(pop)

                val list = this.canGoList(pop)

                list.forEach {
                    if(it.first == this.size -1 && this[it.first][it.second] == 1) {
                        print("YES")
                        return
                    }

                    if(!visited.contains(it)) {
                        stack.push(it)
                    }
                }
            }
        }
    }

    print("NO")
}

private fun Array<Array<Int>>.canGoList(point : Pair<Int,Int>) : ArrayList<Pair<Int,Int>>{
    val result = ArrayList<Pair<Int,Int>>()
    val (first, sec) = point

    if(first != 0) {
        val up = this[first -1][sec]

        if(up == 1)
            result.add(Pair(first -1, sec))
    }

    if(first != this.size -1) {
        val down = this[first + 1][sec]

        if(down == 1)
            result.add(Pair(first +1, sec))
    }

    if(sec != 0) {
        val left = this[first ][sec - 1]

        if(left == 1)
            result.add(Pair(first, sec -1))
    }

    if(sec != this[0].size -1) {
        val right = this[first][sec + 1]

        if(right == 1)
            result.add(Pair(first, sec + 1))
    }

    return result
}

