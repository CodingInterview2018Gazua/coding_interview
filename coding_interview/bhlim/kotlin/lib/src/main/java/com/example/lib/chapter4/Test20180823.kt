package com.example.lib.chapter4

import com.example.lib.linkedlist.LinkedList

fun main(args : Array<String>) {
    val tree = BinaryTree<LinkedList<Int>>()

    val n7 = tree.createNodeWithLinkedList(LinkedList())
    val n6 = tree.createNodeWithLinkedList(LinkedList())
    val n5 = tree.createNodeWithLinkedList(LinkedList())
    val n4 = tree.createNodeWithLinkedList(LinkedList())
    val n3 = tree.createNodeWithLinkedList(LinkedList(), n7)
    val n2 = tree.createNodeWithLinkedList(LinkedList(), n5, n6)
    val n1 = tree.createNodeWithLinkedList(LinkedList(), n3, n4)
    val n0 = tree.createNodeWithLinkedList(LinkedList(), n1, n2)

    tree.linkedRoot = n0
    tree.preOrderWithLinkedList(tree.linkedRoot, 0)
}
