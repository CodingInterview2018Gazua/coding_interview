package com.example.lib.backjoon

import java.util.*
import java.util.regex.Pattern


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val array = ArrayList<String>()

    while (sc.hasNext()) {
        array.add(sc.next())
    }

    array.removeAt(0)

    //val test = arrayOf("ABCD", "145C", "A" , "A910", "Z321")

    array.sortWith(SerialNoComparator())

    val iter = array.iterator()

    while (iter.hasNext()) {
        print("${iter.next()}\n")
    }
}

class SerialNoComparator : Comparator<String> {
    override fun compare(p0: String, p1: String): Int {
        var result = 0

        result = checkLength(p0, p1)

        if (result != 0)
            return result

        result = sumNumber(p0, p1)

        if (result != 0)
            return result

        return checkDictionary(p0, p1)
    }

    private fun checkLength(p0: String, p1: String) = p0.length - p1.length

    private fun sumNumber(p0: String, p1: String) = p0.extractNum().sum() - p1.extractNum().sum()

    private fun String.extractNum() : MutableList<Int> {
        return Pattern.compile(ALPHABET_REGEX)
                .matcher(this)
                .run {
                    val result = ArrayList<Int>()
                    while (find()) {
                        result.add(group(0).toInt())
                    }
                    result
                }
    }

    private fun checkDictionary(p0: String, p1: String): Int {
        return p0.compareTo(p1)
    }

    companion object {
        private const val ALPHABET_REGEX = "[^a-zA-Z]"
    }
}
