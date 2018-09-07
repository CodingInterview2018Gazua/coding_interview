# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/10211
풀이: 누적 합이 0보다 작아지면 다시 누적 합 계산하는 방식으로 가장 큰 누적합 찾기
"""

t = int(input())
for _ in range(t):
    n = int(input())
    x = list(map(int, input().split()))

    max_sub = x[0]
    accumulate = 0
    for item in x:
        accumulate += item
        if max_sub < accumulate:
            max_sub = accumulate
        if accumulate < 0:
            accumulate = 0
    print(max_sub)
