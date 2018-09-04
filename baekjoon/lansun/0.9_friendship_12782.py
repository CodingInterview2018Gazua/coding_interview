# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/12782
"""


def bit_friendship(a, b):
    zero_count = once_count = 0
    for i in range(len(a)):
        if a[i] != b[i]:
            zero_count += a[i].count('0')
            once_count += a[i].count('1')

    return max(zero_count, once_count)


n = raw_input().strip()
bit_list = list(raw_input().strip() for i in range(int(n)))

for bit in bit_list:
    a, b = bit.split()
    print bit_friendship(a, b)
