# /usr/bin/python
# -*- coding: utf-8 -*-


class BinaryTree:
    def __init__(self, data=None, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right

    def __repr__(self):
        return "{} <- {} -> {}".format(self.left and self.left.data,
                                       self.data, self.right and self.right.data)


def height(node):
    if node is None:
        return True, -1

    left, left_height = height(node.left)
    right, right_height = height(node.right)

    if not left or not right or abs(left_height - right_height) > 1:
        return False, max(left_height, right_height) + 1

    return True, max(left_height, right_height) + 1


tree = BinaryTree(3)
tree.left = BinaryTree(2)
# tree.left.left = BinaryTree(1)
# tree.left.left.left = BinaryTree(0)
tree.right = BinaryTree(5)
# tree.right.left = BinaryTree(4)
# tree.right.right = BinaryTree(6)

print tree
# 2 <- 3 -> 5

r, h = height(tree)
print r, h
# True 1

print r
# True