# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/1094
풀이: 구현 문제
"""

x = int(input())
if x == 64:
    print(1)
else:
    shortest_stick = 64
    sum = 0
    count = 0
    while sum != x:
        half_stick = shortest_stick / 2
        if sum + half_stick <= x:
            sum += half_stick
            count += 1
        shortest_stick = half_stick
    print(count)
