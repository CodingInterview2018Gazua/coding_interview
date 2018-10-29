# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/6603
풀이: Python의 Combination 함수 활용
"""

import itertools

while True:
    line = input().split()
    k = line[0]
    if k == '0':
        break
    s = line[1:]
    combinations = itertools.combinations(s, 6)
    for combination in combinations:
        answer = ""
        for item in combination:
            answer += item + " "
        print(answer)
    print()
