# /usr/bin/python
# -*- coding: utf-8 -*-
# Python 2.7.10

# 4.3 오름차순으로 정렬된 배열로부터 그 높이가 가장 낮은 이진 탐색 트리를 생성하는 알고리즘을 작성하라.
# 배열 내 모든 원소는 배열 내에서 유일한 값을 갖는다.


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def insert(self, left, right):
        self.left.append(left)
        self.right.append(right)


def create_bst(arr, start, end):
    if end < start:
        return None

    mid_index = (start + end) / 2
    node = Node(int(arr[mid_index]))
    print node.data
    node.left = create_bst(arr, start, mid_index - 1)
    node.right = create_bst(arr, mid_index + 1, end)

    return node


arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
root = create_bst(arr, 0, len(arr) - 1)
#         5
#       1  2
#      3    4
#    6       7
#   8         9
