# -'*' coding: utf-8 '*'
import Queue


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def add_left(self, node):
        self.left = node

    def add_right(self, node):
        self.right = node

    def __repr__(self):
        return "{}".format(self.data)


class Tree:
    def __init__(self, node):
        self.node = node
        self.next = [None] * 10
        self.i = 0

    def inorder(self, node):
        if node is None:
            return

        self.inorder(node.left)

        self.next[self.i] = node
        self.i += 1

        self.inorder(node.right)

    def search(self, target):
        for i, n in enumerate(self.next):
            if n is target:
                return self.next[i+1]


root = Node(4)

left = Node(2)
right = Node(6)
root.add_left(left)
root.add_right(right)

left_left = Node(1)
left_right = Node(3)
left.add_left(left_left)
left.add_right(left_right)

right_left = Node(5)
right_right = Node(7)
right.add_left(right_left)
right.add_right(right_right)

'''
                4
        2               6
    1       3       5       7
'''

tree = Tree(root)
tree.inorder(root)

print tree.search(left_right)
