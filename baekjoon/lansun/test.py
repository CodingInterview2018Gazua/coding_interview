# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

"""
in order : left root right
pre order : root left right
post order : left right root
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


ret = []


def inorder_traversal(root):
    traverse(root)

    return ret


def traverse(root):
    if root is None: return None
    traverse(root.left)
    ret.append(root.data)
    traverse(root.right)


n = [1, None, 2, 3]
print inorder_traversal(n)
