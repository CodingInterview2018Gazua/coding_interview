package com.example.lib.chapter9

fun main(args: Array<String>) {
    print("abcde".getPermutation())
}

private fun String?.getPermutation(): MutableList<String>? {
    this?.let {
        val permutation = ArrayList<String>()

        if (isEmpty()) {
            permutation.add("")
            return permutation
        }

        val first = this[0]

        substring(1).getPermutation()?.forEach { word ->
            for (i in 0 until word.length + 1) {
                val str = word.insertCharAt(first, i)
                permutation.add(str)
            }
        }

        return permutation
    }

    return null
}

private fun String.insertCharAt(char: Char, i: Int) = substring(0, i) + char + substring(i)