package com.example.lib.chapter5

fun main(args : Array<String>) {
    overlapBits(8,2,1)
}

fun overlapBits(dest : Int, target: Int, start : Int) {
    val destBit = dest.convertToBinary()
    val targetStr = target.convertToBinary()

    print("dest = ")
    destBit.printToBit()
    print("target = ")
    targetStr.printToBit()

    for ((idx, i) in (start until destBit.bitLength()).withIndex()) {
        destBit[i] = targetStr[idx]
    }

    print("Result ")
    destBit.printToBit()
}