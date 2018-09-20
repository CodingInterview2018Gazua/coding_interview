# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

import sys
from collections import defaultdict

sys.setrecursionlimit(100000)

cache = []
def coin_count(coin, remain):
    if remain == 0: return 1
    if remain < 0 or coin < 0: return 0
    if cache[coin][remain] != -1: return cache[coin][remain]

    cache[coin][remain] = coin_count(coin - 1, remain) + coin_count(coin, remain - coins[coin])
    return cache[coin][remain]


"""
unilep님 설명듣고 푼 방식
"""
def coin_count_dp(coin, target_price):
    d = defaultdict(lambda: 0)
    d[0] = 1
    for i in range(len(coins)):
        for j in range(coins[i], target_price + 1):
            d[j] += d[j - coins[i]]

    return d[target_price]


loop_count = int(sys.stdin.readline().strip())
for i in range(loop_count):
    n = int(sys.stdin.readline().strip())
    coins = map(int, sys.stdin.readline().split())
    target_price = int(sys.stdin.readline())

    cache = [[-1] * (target_price + 1) for _ in range(n)]

    print(coin_count(n - 1, target_price))
    print(coin_count_dp(n, target_price))





