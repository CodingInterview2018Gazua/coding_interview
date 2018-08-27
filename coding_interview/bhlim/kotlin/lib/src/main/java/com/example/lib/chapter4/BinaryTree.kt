package com.example.lib.chapter4

import com.example.lib.linkedlist.LinkedList
import java.util.HashMap



class BinaryTree<T> {
    var root: TreeNode<T>? = null
    var linkedRoot: TreeNode<LinkedList<Int>>? = null

    var lastDepth = 0
    var nodeCounter: MutableMap<Int, Int> = HashMap()

    var nodeDatas: MutableSet<Int> = HashSet()
    var isBinarySearchTree = true

    fun createNode(data: T, bt1: TreeNode<T>? = null, bt2: TreeNode<T>? = null): TreeNode<T> {
        val root = TreeNode(data)
        root.left = bt1
        root.right = bt2

        return root
    }

    fun createNodeWithLinkedList(data: LinkedList<Int>, bt1: TreeNode<LinkedList<Int>>? = null, bt2: TreeNode<LinkedList<Int>>? = null): TreeNode<LinkedList<Int>> {
        val root = TreeNode(data)
        root.left = bt1
        root.right = bt2

        return root
    }

    fun preOrder(root: TreeNode<T>?, depth: Int) {
        if (root != null) {
            root.depth = depth
            System.out.printf("depth = %d data = %s\n", depth, root.data.toString())

            preOrder(root.left, depth + 1)
            preOrder(root.right, depth + 1)

            if (lastDepth <= depth)
                lastDepth= depth
        }
    }

    fun preOrderWithLinkedList(root: TreeNode<LinkedList<Int>>?, depth: Int) {
        if (root != null) {
            root.depth = depth

            for (i in 0 .. root.depth) {
                root.data.addNode(i)
            }

            System.out.printf("depth = %d\n", depth)

            root.data.printNodes()

            preOrderWithLinkedList(root.left, depth + 1)
            preOrderWithLinkedList(root.right, depth + 1)

            if (lastDepth <= depth)
                lastDepth= depth
        }
    }

    fun calculateNodeAndDepth(root: TreeNode<T>?, currentdepth: Int) {
        var depth = currentdepth
        if (root != null) {
            if (nodeCounter.containsKey(depth)) {
                nodeCounter[depth] = nodeCounter[depth]?.plus(1) ?: depth
            } else {
                nodeCounter[depth] = 1
            }

            root.depth = depth

            calculateNodeAndDepth(root.left, depth + 1)
            calculateNodeAndDepth(root.right, depth + 1)

            if (lastDepth <= depth)
                lastDepth = depth

        }
    }

    fun isBalanced(): Boolean {
        val lastDepthCount = nodeCounter[lastDepth]
        return lastDepthCount?.toDouble() == Math.pow(2.0, lastDepth.toDouble())
    }

    fun checkBinarySearchTree(node: TreeNode<Int>?) {
        if (isBinarySearchTree && node != null) {
            if(nodeDatas.contains(node.data)) {
                isBinarySearchTree = false
                return
            } else {
                nodeDatas.add(node.data)
            }

            if(node.left != null &&  node.left?.data!! < node.data) {
                checkBinarySearchTree(node.left)
            } else if(node.left != null){
                isBinarySearchTree = false
                return
            }

            if(node.right != null &&  node.right?.data!! > node.data) {
                checkBinarySearchTree(node.right)
            } else if(node.right != null){
                isBinarySearchTree = false
                return
            }
        }
    }
}