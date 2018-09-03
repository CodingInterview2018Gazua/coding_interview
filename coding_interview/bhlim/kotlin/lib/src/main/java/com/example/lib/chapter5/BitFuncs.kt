package com.example.lib.chapter5

fun Int.convertToBinary() : BooleanArray {
    var temp = this
    val container = BooleanArray(32)
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