package com.example.lib.backjoon

import java.util.*


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val datas = ArrayList<Int>()

    while (sc.hasNext()) {
        datas.add(sc.next().toInt())
    }

    //val datas: IntArray = intArrayOf(50, 30, 24, 5, 28, 45, 98, 53, 60)
    var root: TreeNode? = null

    val iter = datas.iterator()

    while (iter.hasNext()) {
        root = BinarySearchTree.addNode(root, iter.next())
    }

    BinarySearchTree.postOrder(root)
}

class BinarySearchTree {
    companion object {
        fun addNode(node: TreeNode?, data: Int): TreeNode {
            return if (node == null) {
                TreeNode(data)
            } else {
                val cur: TreeNode

                if (data <= node.data!!) {
                    cur = addNode(node.left, data)
                    node.left = cur
                } else {
                    cur = addNode(node.right, data)
                    node.right = cur
                }

                node
            }
        }

        fun postOrder(node: TreeNode?) {
            if (node != null) {
                postOrder(node.left)
                postOrder(node.right)
                System.out.printf("${node.data}\n")
            }
        }
    }
}

data class TreeNode(var data: Int? = null
                    , var left: TreeNode? = null
                    , var right: TreeNode? = null)