# /usr/bin/python
# -*- coding: utf-8 -*-
# Python 2.7.10

# 4.8 T2가 T1의 하위 트리인지 판별하는 알고리즘을 만들어라


class BinaryNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def contains_tree(t1, t2):
    if t2 is None: return True
    return is_sub_tree(t1, t2)


def is_sub_tree(t1, t2):
    if t1 is None or t2 is None: return True

    if match_tree(t1, t2): return True

    return is_sub_tree(t1.left, t2) or is_sub_tree(t1.right, t2)


def match_tree(t1, t2):
    if t1 is None and t2 is None: return True
    if t1 is None or t2 is None: return False

    if t1.data != t2.data: return False

    return t1.data == t2.data and \
           match_tree(t1.left, t2.left) and \
           match_tree(t1.right, t2.right)


"""
T2:
  1
 / \
2   3

T1:
  1
 / \
2   3
     \
      4
"""
t1 = BinaryNode(2)
t1.left = BinaryNode(2)
t1.right = BinaryNode(3)
t1.right.right = BinaryNode(4)

t2 = BinaryNode(1)
t2.left = BinaryNode(2)
t2.right = BinaryNode(3)

print contains_tree(t1, t2)

# Another examples
#
# """ TREE 1
#               26
#             /   \
#           10     3
#         /    \     \
#       4      6      3
#        \
#         30
#     """
#
# t1 = BinaryNode(26)
# t1.right = BinaryNode(3)
# t1.right.right = BinaryNode(3)
# t1.left = BinaryNode(10)
# t1.left.left = BinaryNode(4)
# t1.left.left.right = BinaryNode(30)
# t1.left.right = BinaryNode(6)
#
# """ TREE 2
#           10
#         /    \
#       4      6
#        \
#         30
#     """
# t2 = BinaryNode(10)
# t2.right = BinaryNode(6)
# t2.left = BinaryNode(4)
# t2.left.right = BinaryNode(30)
#
# print is_sub_tree(t1, t2)
