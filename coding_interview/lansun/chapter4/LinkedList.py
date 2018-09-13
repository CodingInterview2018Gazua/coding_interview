# /usr/bin/python
# -*- coding: utf-8 -*-


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

    def get_data(self):
        return self.data

    def get_next(self):
        return self.next

    def set_data(self, data):
        self.data = data

    def set_next(self, next):
        self.next = next


class LinkedList:
    def __init__(self, data=None):
        self.head = data
        self.tail = None
        self.size = 0

    def is_empty(self):
        return self.head is None

    def add(self, data):
        temp = Node(data)
        temp.set_next(self.head)
        self.head = temp
        self.size += 1

    def remove_first(self):
        temp = self.head
        self.head = temp.get_next()
        temp = None
        self.size -= 1

    def remove_first(self):
        temp = self.head
        self.head = temp.get_next()
        temp = None
        self.size -= 1

    def remove_node(self, data):
        prev = None
        current = self.head

        while current:
            if current.get_data() == data:
                if prev is None:
                    self.head = current.get_next()
                    current.set_next(None)
                prev.set_next(current.get_next())

            prev = current
            current = current.get_next()

        self.size -= 1

    def remove(self, k):
        if k == 0:
            return self.remove_first()

        current = self.head
        for i in range(k - 1):
            current = current.get_next()

        todo_deleted = current.get_next()
        current.set_next(current.get_next().get_next())

        returned = todo_deleted
        if todo_deleted == self.tail:
            self.tail = current

        todo_deleted = None
        self.size -= 1

        return returned

    def pop(self):
        if not self.is_empty():
            answer = self.head.data
            self.head = self.head.next
            self.size -= 1
            return answer

    def remove_last(self):
        return self.remove(self.size - 1)

    def length(self):
        return self.size

    def to_string(self):
        if self.head is None:
            return '[]'

        current_node = self.head
        string = []
        while current_node is not None:
            string.append(current_node.get_data())
            current_node = current_node.get_next()

        return string

