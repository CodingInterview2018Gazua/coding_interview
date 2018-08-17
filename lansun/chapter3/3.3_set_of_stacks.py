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
set_of_stack.push(1)
set_of_stack.push(2)
set_of_stack.push(3)
set_of_stack.push(4)
set_of_stack.push(5)
set_of_stack.push(6)
set_of_stack.push(7)
set_of_stack.push(7)

print "stacks push >>>>>>>>>>>>>"
print set_of_stack.stacks
print
print "stacks pop  >>>>>>>>>>>>>"
set_of_stack.pop()
set_of_stack.pop()
set_of_stack.pop()
print set_of_stack.stacks