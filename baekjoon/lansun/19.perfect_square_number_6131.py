# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

result = 0
end = 501
n = int(raw_input())
for i in range(1, end):
    for j in range(i, end):
        result += j ** 2 - i ** 2 == n
print result
