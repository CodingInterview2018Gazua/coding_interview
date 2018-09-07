# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

"""
https://www.acmicpc.net/problem/10211

- DP > Kadane's algorithm 사용 (O(n))
"""


def max_subarray(x):
    maximum_ending = maximum_so_far = x[0]
    for i in x[1:]:
        maximum_ending = max(i, maximum_ending + i)
        maximum_so_far = max(maximum_so_far, maximum_ending)

    return maximum_so_far


n = raw_input().strip()
numbers = []
for i in range(int(n)):
    array_number = raw_input().strip()
    numbers.append(raw_input().split())

for number in numbers:
    print max_subarray(map(int, number))