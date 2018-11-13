package com.example.lib.backjoon


fun main(args: Array<String>) {

    //var args1 = arrayOf(3,10,50,60,100,100,200,300)

    //var args1 = arrayOf(35, 56, 67, 90, 67, 80, 500 ,600)
//    print(checkRect(args1[0],
//            args1[1],
//            args1[2],
//            args1[3],
//            args1[4],
//            args1[5],
//            args1[6],
//            args1[7]))

    print(checkRect(args[0].toInt(),
            args[1].toInt(),
            args[2].toInt(),
            args[3].toInt(),
            args[4].toInt(),
            args[5].toInt(),
            args[6].toInt(),
            args[7].toInt()))
}

fun checkRect(left: Int, bot: Int, right: Int, top: Int, left1: Int, bot1: Int, right1: Int, top1: Int): String {
    //var overlapWidth = 0
    //var overlapHeight = 0

    if (checkPoint(left, bot, right, top, left1, bot1, right1, top1))
        return "c"

    if (checkLine(left, bot, right, top, left1, bot1, right1, top1))
        return "b"

    if (checkOverlap(left, bot, right, top, left1, bot1, right1, top1)) {
//        if (left <= right1)
//            overlapWidth = right - left1
//        else
//            overlapWidth = right1 - left
//
//        if (top <= top1)
//            overlapHeight = top - bot1
//        else
//            overlapHeight = top1 - bot
        return "a"

    } else {
        return "d"
    }
}

fun checkOverlap(left: Int, bot: Int, right: Int, top: Int, left1: Int, bot1: Int, right1: Int, top1: Int): Boolean {
    if (!(left1 in left..right || right1 in left..right))
        return false

    if (!(top1 in top..bot || bot1 in top..bot))
        return false

    return true
}

fun checkPoint(left: Int, bot: Int, right: Int, top: Int, left1: Int, bot1: Int, right1: Int, top1: Int): Boolean {
    return if (bot == top1 || top == bot1) {
        right == left1 && left == right1
    } else
        false
}

fun checkLine(left: Int, bot: Int, right: Int, top: Int, left1: Int, bot1: Int, right1: Int, top1: Int): Boolean {
    if (bot == top1 || top == bot1) {
        return !(right == left1 && left == right1)
    } else if (left == right1 || right == left1) {
        return !(right == left1 && left == right1)
    }

    return false
}