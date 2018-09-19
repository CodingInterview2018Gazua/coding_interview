# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/2263
"""

n = int(input())
in_order = list(map(int, input().split()))
post_order = list(map(int, input().split()))

in_order_map = [-1 for _ in range(n + 1)]
for i in range(n):
    in_order_map[in_order[i]] = i

stack = [(0, n - 1, 0, n - 1)]
pre_order = ""
while len(stack) != 0:
    (in_left, in_right, post_left, post_right) = stack.pop()
    root = post_order[post_right]
    pre_order += str(root) + " "
    center = in_order_map[root]
    right = center - in_left
    if center + 1 <= in_right:
        stack.append((center + 1, in_right, post_left + right, post_right - 1))
    if in_left <= center - 1:
        stack.append((in_left, center - 1, post_left, post_left + right - 1))

print(pre_order)
