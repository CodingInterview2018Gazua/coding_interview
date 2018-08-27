# /usr/bin/python
# -*- coding: utf-8 -*-
# Python 2.7.10

# 4.5 어떤 이진 트리가 이진 탐색 트리인지 판별하는 함수를 구현하라
import sys


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def is_bst(btree, minimun, maximum):
    if btree is None: return True
    if btree.data <= minimun or btree.data > maximum: return False

    return is_bst(btree.left, minimun, btree.data) and is_bst(btree.right, btree.data, maximum)


root = Node(1)
root.left = Node(2)

is_bst = is_bst(btree=root, minimun=-sys.maxint - 1, maximum=sys.maxint)
print is_bst # False
