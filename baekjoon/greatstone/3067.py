# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/3067
"""

t = int(input())
for _ in range(t):
    n = int(input())
    coins = list(map(int, input().split()))
    m = int(input())

    nmr_cases = [0 for _ in range(m + 1)]
    nmr_cases[0] = 1

    for coin in coins:
        for amount in range(coin, m + 1):
            nmr_cases[amount] += nmr_cases[amount - coin]

    print(nmr_cases[m])
