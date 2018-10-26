# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/13565
풀이: BFS 탐색
"""

import collections

m, n = map(int, input().split())
textile = [input() for _ in range(m)]
percolate = [[False for _ in range(n)] for _ in range(m)]

q = collections.deque()
for j in range(n):
    if textile[0][j] == '0':
        q.append([0, j])

while q:
    i, j = q.popleft()
    if 0 <= i < m and 0 <= j < n and \
        textile[i][j] == '0' and not percolate[i][j]:
        if i == m - 1:
            print("YES")
            break
        percolate[i][j] = True
        q.append([i - 1, j])
        q.append([i + 1, j])
        q.append([i, j - 1])
        q.append([i, j + 1])
else:
    print("NO")
