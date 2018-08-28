# /usr/bin/python
# -*- coding: utf-8 -*-
# Python 2.7.10

# 4.6


class TreeNode:
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None

    def add_left(self, data):
        self.left = data

    def add_right(self, data):
        self.right = data


def inorderSuccessor(root, p):
    successor = None
    while root:
        if root.data > p.data:
            successor = root
            root = root.left
        else:
            root = root.right
    return successor

tree_root = TreeNode(4)

left = TreeNode(2)
right = TreeNode(6)
tree_root.add_left(left)
tree_root.add_right(right)

left_left = TreeNode(1)
left_right = TreeNode(3)
left.add_left(left_left)
left.add_right(left_right)

right_left = TreeNode(5)
right_right = TreeNode(7)
right.add_left(right_left)
right.add_right(right_right)

temp = left_right
succ = inorderSuccessor(tree_root, temp)


if succ is not None:
    print 'In-order Successor of {} is {}.'.format(temp.data, succ.data)
else:
    print 'In-order Successor doesnt exist'

