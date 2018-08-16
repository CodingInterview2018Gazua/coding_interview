# /usr/bin/python
# -*- coding: utf-8 -*-

# 3.1 하나의 배열을 사용해 세 개의 스택을 구현하는 방법을 설명하라


class Stack:
    def __init__(self):
        self.storage = []

    def push(self, data):
        self.storage.append(data)

    def pop(self):
        self.storage.pop()

    def is_empty(self):
        return len(self.storage) == 0

    def peek(self):
        return self.storage[-1]

    def length(self):
        return len(self.storage)


# [0] [1]     [n/3]   [n/3]+1        [n-1]    [n]
# 0    1   2    3        4       5     6       7
# s1->        s3->                          <-s2
# stack1 top : -1
# stack2 top : len(list_size)
# stack3 top : len(list_size) / 3
class ThreeStack:
    def __init__(self, list_size):
        self.list_size = list_size
        self.storage = [None] * list_size
        self.top_1 = -1
        self.top_2 = list_size
        self.top_3 = list_size / 3

    def push(self, stack_num, data):
        top = self.get_stack_top(stack_num)
        self.storage[top] = data

    def pop(self, stack_num):
        top = self.get_stack_top(stack_num)
        self.storage[top].pop()

    def get_stack_top(self, stack_num):
        if stack_num == 1:
            self.top_1 += 1
            return self.top_1
        elif stack_num == 2:
            self.top_2 -= 1
            return self.top_2
        else:
            self.top_3 += 1
            return self.top_3

    def is_empty(self):
        return len(self.storage) == 0

    def peek(self):
        return self.storage[-1]

    def length(self):
        return len(self.storage)

stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)
stack.peek()
stack.pop()
stack.storage

# 3.1 하나의 배열을 사용해 세 개의 스택을 구현하는 방법을 설명하라
lists = [i for i in xrange(1, 7, 1)]

three_stack = ThreeStack(len(lists))
three_stack.push(1, 1)
three_stack.push(1, 2)
three_stack.push(2, 3)
three_stack.push(3, 4)
three_stack.push(1, 5)
three_stack.push(1, 6)
three_stack.push(1, 7)
three_stack.push(3, 8)

print "list          >>>> {}".format(lists)
print "divide stacks >>>> {}".format(three_stack.storage)