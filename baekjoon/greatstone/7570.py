#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/7570
풀이: 줄 서 있는 아이들 중 연속되는 숫자로 가장 길게 정렬된 그룹을 제외한 아이들의 수가 답이다.
     예를 들어 입력이 1, 4, 2, 3, 5 연속되는 숫자로 가장 길게 정렬된 그룹은 (1, 2, 3)이고,
     5명 중 3명을 제외한 2명을 움직이면 되므로 답은 2이다.
     (longest increasing subsequence 의 변형으로 보임)
"""

nmrChildren = int(input())
childList = list(map(int, input().split()))

increase = [0] * (nmrChildren + 1)
for child in childList:
    increase[child] = increase[child - 1] + 1
print(nmrChildren - max(increase))
