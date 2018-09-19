package com.example.lib.chapter9

fun main(args: Array<String>) {
    val result = intArrayOf(1, 2, 3)
            .toCollection(ArrayList())
            .getSubSets(0)

    print(result)
}

private fun MutableList<Int>.getSubSets(idx: Int): MutableList<MutableList<Int>>? {
    val allSubSets: MutableList<MutableList<Int>>?

    if (size == idx) {
        allSubSets = ArrayList()
        allSubSets.add(ArrayList())
    } else {
        allSubSets = getSubSets(idx + 1)
        val item = this[idx]
        val moreSuSet = ArrayList<MutableList<Int>>()

        allSubSets?.forEach {
            val newSubset = ArrayList<Int>().apply {
                addAll(it)
                add(item)
            }

            moreSuSet.add(newSubset)
        }

        allSubSets?.addAll(moreSuSet)

    }

    return allSubSets
}