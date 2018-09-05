# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/12782
풀이: N과 M의 다른 비트 중 0과 1의 개수 중 많은 것이 답
"""
T = int(input())
for _ in range(T):
    N, M = input().split()
    cntDiff0 = 0
    cntDiff1 = 0
    for n, m in zip(N, M):
        if n != m:
            if n == '0':
                cntDiff0 += 1
            else:
                cntDiff1 += 1
    print(max(cntDiff0, cntDiff1))
