# /usr/bin/python
# -*- coding: utf-8 -*-


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


class Sort:
    def __init__(self, stack):
        self.stack = stack

    def insertion(self):
        stack = self.stack
        for i in range(stack.length()):
            top = stack.storage[i]
            j = i-1 # last
            while (j > -1) and top < stack.storage[j]:
                stack.storage[j+1] = stack.storage[j]
                j -= 1
            stack.storage[j+1] = top

        return stack.storage

stack = Stack()
stack.push(5)
stack.push(3)
stack.push(2)
stack.push(6)
stack.push(0)

print "original stack >>>>>>>"
print stack.storage
print "======================="
# [5, 3, 2, 0, 6]

print "sorted   stack >>>>>>>"
desc_stack = Sort(stack)
print desc_stack.insertion()
# [0, 2, 3, 5, 6]
