# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7


"""
https://www.acmicpc.net/problem/2263

preorder
in order : left root right
pre order : root left right
post order : left right root
"""


def preorder(inorder, postorder):
    root = postorder[-1]
    root_idx = inorder.index(root)

    left = inorder[:root_idx]
    right = inorder[root_idx+1:]

    preordered = [root] + left + right
    return ' '.join(str(e) for e in preordered)


n = 3 #raw_input()
inorder = [1, 2, 3] #map(int, raw_input().split())
postorder = [1, 3, 2] #map(int, raw_input().split())

print preorder(inorder, postorder)
