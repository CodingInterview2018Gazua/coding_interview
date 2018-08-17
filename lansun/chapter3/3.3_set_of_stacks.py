# /usr/bin/python
# -*- coding: utf-8 -*-

# 3.3 setofstacks는 여러 스택으로 구성되어야 하며 이전 스택이 지정된 용량을 초과하는 경우
# 새로운 스택을 생성해야 한다 setofstacks.push()와 pop()은 정확히 하나의 스택이 있을때와
# 동일한 값을 반환해야 한다


class SetOfStack:
    def __init__(self, capacity):
        self.capacity = capacity
        self.stacks = []

    def push(self, data):
        if len(self.stacks) == 0 or len(self.stacks[-1]) == self.capacity:
            self.stacks.append([])
        self.stacks[-1].append(data)

    def pop(self):
        if len(self.stacks) == 0:
            return None

        self.stacks[-1].pop()

        if len(self.stacks[-1]) == 0:
            self.stacks.pop()


# 출력
set_of_stack = SetOfStack(capacity=3)
[set_of_stack.push(i) for i in range(1, 11)]
print "stacks push >>>>>>>>>>>>>"
print set_of_stack.stacks
print

# output
# stacks push >>>>>>>>>>>>>
# [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]

print "stacks pop  >>>>>>>>>>>>>"
[set_of_stack.pop() for i in range(3)]
print set_of_stack.stacks

# output
# stacks pop  >>>>>>>>>>>>>
# [[1, 2, 3], [4, 5, 6], [7]]
