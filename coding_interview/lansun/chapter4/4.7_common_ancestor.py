# /usr/bin/python
# -*- coding: utf-8 -*-
# Python 2.7.10

# 4.7


class BinaryNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def find_path(root, path, k):
    if root is None: return False

    path.append(root.data)

    if root.data == k: return True

    if ((root.left is not None and find_path(root.left, path, k)) or
       (root.right is not None and find_path(root.right, path, k))):
        return True

    path.pop()
    return False


def lca(root, n1, n2):
    path1 = []
    path2 = []

    if not find_path(root, path1, n1) or not find_path(root, path2, n2):
        return -1

    i = 0
    while i < len(path1) and i < len(path2):
        if path1[i] != path2[i]:
            break
        i += 1
    return path1[i - 1]


root = BinaryNode(1)
root.left = BinaryNode(2)
root.right = BinaryNode(3)
root.left.left = BinaryNode(4)
root.left.right = BinaryNode(5)
root.right.left = BinaryNode(6)
root.right.right = BinaryNode(7)

"""
          1
    2           3
 4     5     6     7
"""
print lca(root, 4, 5)
print lca(root, 4, 6)
print lca(root, 3, 4)
print lca(root, 2, 4)

