# /usr/bin/python
# -*- coding: utf-8 -*-

# 4.3 오름차순으로 정렬된 배열로부터 그 높이가 가장 낮은 이진 탐색 트리를 생성하는 알고리즘을 작성하라.
# 배열 내 모든 원소는 배열 내에서 유일한 값을 갖는다.


class BinaryTree:
    def __init__(self, data):
        self.data = data
        self.left = []
        self.right = []

    def insert(self, left, right):
        self.left.append(left)
        self.right.append(right)

    def __repr__(self):
        return "{} <- {} -> {}".format(self.left[0], self.data, self.right[0])


arr = [0, 1, 2, 3, 4]
arr_mid = len(arr) / 2

bt = BinaryTree(arr[arr_mid])
bt.insert(arr[:arr_mid], arr[arr_mid+1:])

print bt
# [0, 1] <- 2 -> [3, 4]