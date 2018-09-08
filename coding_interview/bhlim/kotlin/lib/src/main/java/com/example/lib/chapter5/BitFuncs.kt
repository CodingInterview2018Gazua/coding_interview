package com.example.lib.chapter5

fun Int.convertToBinary(bit : Int) : BooleanArray {
    var temp = this
    val container = BooleanArray(bit)
    var i = 0

    while (temp > 0) {
        container[i] = temp % 2 != 0
        i++
        temp /= 2
    }

    return container
}

fun BooleanArray.printToBit() {
    for (i in this.size - 1 downTo 0) {
        if(this[i])
            print(1)
        else
            print(0)
    }

    print("\n")
}

fun BooleanArray.convertToString() : String {
    var bitStr = ""

    for (i in this.size - 1 downTo 0) {
        bitStr += if(this[i])
            "1"
        else
            "0"
    }

    return bitStr
}

fun BooleanArray.bitLength() : Int {
    var size = this.size

    for (i in this.size - 1 downTo 0) {
        if(this[i])
            break
        else
            size--
    }

    return size
}

fun BooleanArray.getBit1Count() : Int {
    var count = 0

    for (i in this.size - 1 downTo 0) {
        if(this[i])
            count++
    }

    return count
}