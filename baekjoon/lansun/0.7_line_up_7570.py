# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/7570
"""

# 앞이나 뒤로 보내는 어린이 수의 최소값 말고 안 보내는 어린이 수의 최대값을 구해 보세요
n = int(raw_input())
dp = [0] * (n + 1)
lines = map(int, raw_input().split())
for line in lines:
    dp[line] = dp[line - 1] + 1

print n - max(dp)

