#!/usr/bin/python
# -*- coding: utf-8 -*-

# 2.1 다음의 비정렬 연결리스트에서 중복 문자를 제거하는 코드를 작성하라
# 임시 버퍼가 허용되지 않는 상황에서 이 문제를 어떻게 해결할 수 있겠는가 (고민해야 한다)


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


class UnorderedLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def is_empty(self):
        return self.head is None

    def add(self, data):
        temp = Node(data)
        temp.set_next(self.head)
        self.head = temp
        self.size += 1

    def length(self):
        return self.size

    # 2.5번 문제
    def sum(self, linkedlist1, linkedlist2):
        l1 = linkedlist1.head
        l2 = linkedlist2.head
        sum_linkedlist = UnorderedLinkedList()
        carry = 0

        while l1 or l2:
            result = carry
            if l1:
                result += l1.get_data()
                l1 = l1.get_next()
            if l2:
                result += l2.get_data()
                l2 = l2.get_next()

            sum_linkedlist.add(result % 10) # 나머지
            carry = result // 10            # 몫

        if carry > 0:
            sum_linkedlist.add(carry)

        return sum_linkedlist.to_string()

    def to_string(self):
        if self.head is None:
            return None

        current_node = self.head
        string = ''
        while current_node is not None:
            string += str(current_node.get_data())
            current_node = current_node.get_next()

        return string

print ">>> 2.5 연결리스트 수를 더하여 그 합을 연결 리스트로 반환 "
linkedlist1 = UnorderedLinkedList()
linkedlist1.add(6)
linkedlist1.add(1)
linkedlist1.add(7)

linkedlist2 = UnorderedLinkedList()
linkedlist2.add(2)
linkedlist2.add(9)
linkedlist2.add(5)

print linkedlist1.sum(linkedlist1, linkedlist2)
# 912