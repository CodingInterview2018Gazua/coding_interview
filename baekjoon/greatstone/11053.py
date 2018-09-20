# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/11053
풀이: nmr_max_increase 에 인덱스 i까지 계산된 증가하는 가장 긴 부분 수열 수를 이용해 이후 인덱스의 값을 계산한다.
"""

n = int(input())
a = list(map(int, input().split()))

nmr_max_increase = [1 for _ in range(n)]
for i in range(n):
    for j in range(i + 1, n):
        if a[i] < a[j]:
            nmr_max_increase[j] = max(nmr_max_increase[j], nmr_max_increase[i] + 1)

print(max(nmr_max_increase))
