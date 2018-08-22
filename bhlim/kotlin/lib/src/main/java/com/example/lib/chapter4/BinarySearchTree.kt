package com.example.lib.chapter4

class BinarySearchTree {
    var root: TreeNode<Int>? = null

    fun preOrder(root: TreeNode<Int>?, depth: Int) {
        if (root != null) {
            System.out.printf("depth = %d data = %s\n", depth, root.data.toString())
            preOrder(root.left, depth + 1)
            preOrder(root.right, depth + 1)
        }
    }

    fun createTreeFromArray(arr: IntArray, startIdx : Int, node : TreeNode<Int>?) {
        var idx = startIdx

        node?.left = TreeNode(arr[idx++])
        node?.right = TreeNode(arr[idx++])

        createTreeFromArray(arr, idx, node?.left)
        createTreeFromArray(arr, idx, node?.right)
    }
}