# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

"""
https://www.acmicpc.net/problem/1431
"""
import string


serial_number = list(string.ascii_uppercase) + list(string.digits)

print serial_number

# 1. A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
# 2. 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
# 3. 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.

# TODO
n = ['ABCD', '145C', 'A', 'A910', 'Z321']
print n

print min(map(len, n))

def quicksort(x):
    if len(x) <= 1:
        return x

    pivot = x[len(x) // 2]
    less = []
    more = []
    equal = []
    for a in x:
        if a < pivot:
            less.append(a)
        elif a > pivot:
            more.append(a)
        else:
            equal.append(a)

    return quicksort(less) + equal + quicksort(more)

print quicksort(n)
# n = raw_input().strip()
# numbers = []
# for i in range(int(n)):
#     array_number = raw_input().strip()
#     numbers.append(raw_input().split())
#
# for number in numbers:
#     print max_subarray(map(int, number))