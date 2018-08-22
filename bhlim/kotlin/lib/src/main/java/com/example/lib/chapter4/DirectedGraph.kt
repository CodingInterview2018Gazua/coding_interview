package com.example.lib.chapter4

import java.util.HashSet
import kotlin.collections.HashMap

data class Vertex(val data: Int) {
    override fun toString(): String {
        return data.toString()
    }
}

class DirectedGraph {
    private val mMap: MutableMap<Vertex, MutableSet<Vertex>> = HashMap()

    private fun addVertex(vertex: Vertex): Boolean {
        if (!mMap.containsKey(vertex)) {
            mMap[vertex] = HashSet()
            return true
        }
        return false
    }

    fun addEdge(from: Vertex, to: Vertex): Boolean {
        if (mMap.containsKey(from)) {
            val dests = mMap[from]
            if (dests?.contains(to) == false) {
                dests.add(to)
                return true
            }
        } else {
            addVertex(from)
            addEdge(from, to)
        }

        return false
    }

    fun isConnected(from: Vertex, to: Vertex): Boolean {
        if (mMap.containsKey(from)) {
            val dests = mMap[from]

            if(dests?.contains(to) == true) {
                return true
            }  else {

            }
        }

        return false
    }

    fun printGragh() {
        println(mMap)
    }
}