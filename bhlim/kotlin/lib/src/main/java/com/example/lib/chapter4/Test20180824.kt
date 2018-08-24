package com.example.lib.chapter4

fun main(args: Array<String>) {
    val tree = BinaryTree<Int>()

    // 일반 binary tree

//    val n7 = tree.createNode(8)
//    val n6 = tree.createNode(7)
//    val n5 = tree.createNode(6)
//    val n4 = tree.createNode(5)
//    val n3 = tree.createNode(4, n7)
//    val n2 = tree.createNode(3, n5, n6)
//    val n1 = tree.createNode(2, n3, n4)
//    val n0 = tree.createNode(1, n1, n2)

    // 일반 binary search tree

    val n10 = tree.createNode(10)
    val n8 = tree.createNode(8)
    val n9 = tree.createNode(9, n8, n10)
    val n1 = tree.createNode(1)
    val n4 = tree.createNode(4)
    val n2 = tree.createNode(2, n1)
    val n6 = tree.createNode(6)
    val n7 = tree.createNode(7, n6, n9)
    val n3 = tree.createNode(3, n2, n4)
    val n5 = tree.createNode(5, n3, n7)

    tree.root = n5
    tree.isBinarySearchTree = true
    tree.checkBinarySearchTree(tree.root)

    print(tree.isBinarySearchTree)
}
