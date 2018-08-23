package com.example.lib.chapter4

data class TreeNode<T>(val data: T
                       , var left: TreeNode<T>? = null
                       , var right: TreeNode<T>? = null) {
    var depth = 0
}

