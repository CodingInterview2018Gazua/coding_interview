package com.example.lib.chapter5

fun main(args : Array<String>) {
    printDiffBitCount(10, 20)
}

private fun printDiffBitCount(src : Int, trg : Int) {
    val srcBitString = src.convertToBinary(bit = 8).convertToString()
    val trgBitString = trg.convertToBinary(bit = 8).convertToString()

    print("Src Int = $src, bitStr = $srcBitString\n")
    print("Target Int = $trg, bitStr = $trgBitString\n")

    var difference = 0

    for(i in 0 until srcBitString.length - 1){
        if(srcBitString[i] != trgBitString[i])
            difference++
    }

    print("difference Connt = $difference")
}