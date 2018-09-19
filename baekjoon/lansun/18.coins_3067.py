# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

import sys
sys.setrecursionlimit(100000)


loop_count = int(sys.stdin.readline().strip())


def coin_count(coin, remain):
    if remain == 0: return 1
    if remain < 0 or coin < 0: return 0
    if cache[coin][remain] != -1: return cache[coin][remain]

    cache[coin][remain] = coin_count(coin - 1, remain) + coin_count(coin, remain - coins[coin])
    return cache[coin][remain]


for i in range(loop_count):
    n = int(sys.stdin.readline().strip())
    coins = map(int, sys.stdin.readline().split())
    target_price = int(sys.stdin.readline())

    cache = [[-1] * (target_price + 1) for _ in range(n)]

    print(coin_count(n - 1, target_price))


