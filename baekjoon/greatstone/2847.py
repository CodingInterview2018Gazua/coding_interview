# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/2847
풀이: 주어진 수들을 역순으로 순회하며 이전 수보다 큰 경우 (이전 수 - 1)로 만든다.
"""

n = int(input())
scores = [int(input()) for _ in range(n)]
answer = 0
for i in range(n - 1, 0, -1):
    if scores[i] <= scores[i - 1]:
        answer += scores[i - 1] - scores[i] + 1
        scores[i - 1] = scores[i] - 1
print(answer)
