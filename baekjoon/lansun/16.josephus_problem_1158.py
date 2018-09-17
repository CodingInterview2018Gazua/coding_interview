# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7


"""
https://www.acmicpc.net/problem/1158
"""
import sys
import collections

queue = collections.deque([]);

n, m = map(int, sys.stdin.readline().strip().split())
for i in range(1, n+1):
    queue.append(i)

result = []
while len(queue) > 0:
    for i in range(m-1):
        queue.append(queue.popleft())

    result.append(str(queue.popleft()))

print '<{}>'.format(', '.join(result))
