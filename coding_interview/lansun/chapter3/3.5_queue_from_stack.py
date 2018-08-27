# /usr/bin/python
# -*- coding: utf-8 -*-


# 3.5 두 개의 스택을 사용하여 큐를 구현하는 MyQueue 클래스를 작성해보라
# stack : LIFO (Last In First Out)
# queue : FIFO (First In First Out)

class Stack:
    def __init__(self):
        self.storage = []

    def push(self, data):
        self.storage.append(data)

    def pop(self):
        return self.storage.pop()

    def peek(self):
        return self.storage[-1]

    def is_empty(self):
        return len(self.storage) == 0

    def length(self):
        return len(self.storage)


class MyQueue:
    def __init__(self):
        self.in_stack = Stack()
        self.out_stack = Stack()

    def enqueue(self, data):
        self.in_stack.push(data)

    def dequeue(self):
        if self.out_stack.length() == 0:
            while self.in_stack.length() > 0:
                self.out_stack.push(self.in_stack.pop())
        return self.out_stack.pop()

    def get(self):
        return self.in_stack.storage[0]

    def peek(self):
        return self.out_stack.storage[1:]

    def remove(self):
        return self.out_stack.pop()

    def qsize(self):
        return self.in_stack.length() + self.out_stack.length()

# stack = Stack()
# [stack.push(i) for i in range(6)]
# print stack.storage
# stack.pop()
# stack.pop()
# print stack.storage

queue = MyQueue()
[queue.enqueue(i) for i in range(6)]

# [0, 1, 2, 3, 4, 5]
print queue.in_stack.storage
# 6
print queue.qsize()

queue.dequeue()
queue.dequeue()
queue.dequeue()
# [5, 4, 3]
print queue.out_stack.storage
# 3
print queue.qsize()
