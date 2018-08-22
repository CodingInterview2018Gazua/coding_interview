package com.example.lib.chapter4

fun main(args : Array<String>) {
    val dg = DirectedGragh()

    val v0 = Vertex(0)
    val v1 = Vertex(1)
    val v2 = Vertex(2)
    val v3 = Vertex(3)
    val v4 = Vertex(4)

    dg.addEdge(v0, v1)
    dg.addEdge(v1, v2)
    dg.addEdge(v2, v3)
    dg.addEdge(v3, v4)
    dg.addEdge(v0, v4)

    dg.printGragh()

    println(dg.isConnected(v0, v1))
    println(dg.isConnected(v1, v3))
    println(dg.isConnected(v0, v4))
}