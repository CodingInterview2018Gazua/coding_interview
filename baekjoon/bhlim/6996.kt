package com.example.lib.backjoon

import java.util.*

fun main(args: Array<String>) {
    "blather".checkAnagram2("reblath")
    "maryland".checkAnagram2("landam")
    "bizarre".checkAnagram2("brazier")
    "brazier".checkAnagram2("brazier")
    "aaaa".checkAnagram2("aaab")

//    val sc = Scanner(System.`in`)
//    val array = ArrayList<String>()
//
//    while (sc.hasNext()) {
//        array.add(sc.next())
//    }
//
//    array.removeAt(0)
//
//    array.forEach {
//        val token = it.split(" ")
//
//        if(token.size == 2)
//            token[0].checkAnagram2(token[1])
//    }
}


private fun String.checkAnagram2(dest: String) {
    val srcArr = toCharArray()
    srcArr.sort()

    val destArr= dest.toCharArray()
    destArr.sort()

    var srcStr = ""
    var destStr = ""

    srcArr.forEach {
        srcStr += it
    }

    destArr.forEach {
        destStr += it
    }

    if(srcStr == destStr) {
        print("$this & $dest are anagrams.\n")
    } else {
        print("$this & $dest are NOT anagrams.\n")
    }
}

private fun String.checkAnagram(dest: String) {
    val srcMap = HashMap<Char, Int>()
    val destMap = HashMap<Char, Int>()

    if (length != dest.length) {
        print("$this & $dest are NOT anagrams.\n")
    } else {
        forEach {
            if (srcMap.containsKey(it)) {
                srcMap[it] = srcMap[it]?.plus(1) ?: 1
            } else {
                srcMap[it] = 1
            }
        }

        dest.forEach {
            if (destMap.containsKey(it)) {
                destMap[it] = destMap[it]?.plus(1) ?: 1
            } else {
                destMap[it] = 1
            }
        }

        srcMap.forEach {
            if (destMap.containsKey(it.key)) {
                if (srcMap[it.key] != destMap[it.key]) {
                    print("$this & $dest are NOT anagrams.\n")
                    return
                }
            } else {
                print("$this & $dest are NOT anagrams.\n")
                return
            }
        }

        print("$this & $dest are anagrams.\n")
    }
}