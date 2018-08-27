# /usr/bin/python
# -*- coding: utf-8 -*-

# 3.2 최솟값을 갖는 원소를 반환하는 min 연산 스택
# 반드시 O(1)이어야 한다


class MinStack:
    def __init__(self):
        self.storage = []
        self.min_storage = []
        self.min = 99999

    def push(self, data):
        self.storage.append(data)
        if self.min > data:
            self.min = data
        self.min_storage.append(self.min)

    def pop(self):
        self.storage.pop()
        self.min_storage.pop()

    def is_empty(self):
        return len(self.storage) == 0

    def peek(self):
        return self.storage[-1]

    def minimum(self):
        return self.min_storage[-1]

    def length(self):
        return len(self.storage)


stack = MinStack()
stack.push(1)
stack.push(3)
stack.push(5)
stack.pop()
stack.pop()
print "stack     >>>> {}".format(stack.storage)
print "min stack >>>> {}".format(stack.minimum())