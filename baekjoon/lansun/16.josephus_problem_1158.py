# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7


"""
https://www.acmicpc.net/problem/1158
"""
import sys
from Queue import Queue

n, m = map(int, sys.stdin.readline().strip().split())
queue = Queue(n)
for i in range(1, n+1):
    queue.put(i)


result = []
while not queue.empty():
    for i in range(m-1):
        queue.put(queue.get())

    result.append(str(queue.get()))

print '<{}>'.format(', '.join(result))