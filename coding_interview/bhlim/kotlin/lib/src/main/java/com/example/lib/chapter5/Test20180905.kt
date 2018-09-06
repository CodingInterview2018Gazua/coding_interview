package com.example.lib.chapter5

fun main(args : Array<String>) {
    20.findSame1BitInteger()
}

fun Int.findSame1BitInteger() {
    var max = -1
    var min = -1

    val srcCount = this.convertToBinary().getBit1Count()

    print("Integer = $this , count  = $srcCount\n")

    for ( i in this + 1 until Int.MAX_VALUE) {
        if(i.convertToBinary().getBit1Count() == srcCount) {
            min = i
            print("found = $min , count  = ${i.convertToBinary().getBit1Count()}\n")
            break
        }
    }

    for ( i in this - 1 downTo 0) {
        if(i.convertToBinary().getBit1Count() == srcCount) {
            max = i
            print("found = $max , count  = ${i.convertToBinary().getBit1Count()}\n")
            break
        }
    }

    print("max = $max , min = $min")
}