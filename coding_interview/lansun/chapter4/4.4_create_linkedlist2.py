# /usr/bin/python
# -*- coding: utf-8 -*-
# Python 2.7.10

# 4.4 주어진 이진 트리에서 깊이별로 연결 리스트 만들어내는 알고리즘을 작성하라
# 트리 깊이가 D라면 알고리즘 수행 결과로 D개의 연결리스트가 만들어져야 한다
from Queue import Queue
# from LinkedList import LinkedList


class LinkedList:
    def __init__(self, data=None):
        self.data = data
        self.next = None

    def add(self, data):
        temp = self

        while temp.next is not None:
            temp = temp.next
            temp.next = LinkedList(data)

    def __repr__(self):
        temp = self
        ret = []
        while temp.next is not None:
            ret.append(temp.data)
            temp = temp.next

        ret.append(temp.data)
        return "{}".format(ret)


class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.next = None

    def add(self, data):
        self.data = TreeNode(data)

    def add_left(self, data):
        self.left = TreeNode(data)

    def add_right(self, data):
        self.right = TreeNode(data)


def create(root, last_node):
    if root is None: return

    if last_node:
        last_node.left = None
        last_node.right = root

    last_node = root
    right = root.right

    create(root.left, last_node)
    create(right, last_node)




root = TreeNode(1)
root.add_left(2)
root.add_right(5)

root.left.add_right(3)
root.left.add_left(4)
root.left.right.add_left(6)

print root
last_node = TreeNode(None)

result = create(root, last_node)
print result
