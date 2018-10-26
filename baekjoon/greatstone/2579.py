# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/2579
풀이: Dynamic Programing.
     1. 두 개의 배열로 계산 결과를 저장해가며 이전 계산 값을 이용한다.
     2. 첫 번째 배열은 특정 계단에 오기 위해 1칸 올라온 경우의 최대 점수를 저장한다.
     3. 두 번째 배열은 특정 계단에 오기 위해 2칸 올라온 경우의 최대 점수를 저장한다.
     4. 두 개의 배열의 마지막 칸 점수 중 큰 수를 출력
"""

n = int(input())
scores = [int(input()) for _ in range(n)]

score_1step = [0 for _ in range(n + 1)]
score_2step = [0 for _ in range(n + 1)]
score_1step[1] = score_2step[1] = scores[0]
for i in range(2, n + 1):
    score_1step[i] = score_2step[i - 1] + scores[i - 1]
    score_2step[i] = max(score_1step[i - 2], score_2step[i - 2]) + scores[i - 1]
print(max(score_1step[n], score_2step[n]))
