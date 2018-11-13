# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

a = int(raw_input())
result = 0
n = 501
for i in range(1, n):
    for j in range(i, n):
        result += j**2 - i**2 == a
print result
