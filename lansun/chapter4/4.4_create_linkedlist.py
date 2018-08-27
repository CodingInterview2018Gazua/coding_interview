# /usr/bin/python
# -*- coding: utf-8 -*-
# Python 2.7.10

# 4.4 주어진 이진 트리에서 깊이별로 연결 리스트 만들어내는 알고리즘을 작성하라
# 트리 깊이가 D라면 알고리즘 수행 결과로 D개의 연결리스트가 만들어져야 한다
from Queue import Queue


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


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def add_left(self, data):
        self.left = Node(data)

    def add_right(self, data):
        self.right = Node(data)


def create(root):
    queue = Queue()
    queue.put(root)

    result_list = []

    while not queue.empty():
        qsize = queue.qsize()
        linkedlist = None

        for i in range(qsize):
            node = queue.get()

            if i == 0:
                linkedlist = LinkedList(node.data)
            else:
                linkedlist.add(node.data)

            if node.left: queue.put(node.left)
            if node.right: queue.put(node.right)

        result_list.append(linkedlist)

    return result_list


root = Node(1)
root.add_left(2)
root.add_right(5)

root.left.add_right(3)
root.left.add_left(4)
root.left.right.add_left(6)

result = create(root)
print result
