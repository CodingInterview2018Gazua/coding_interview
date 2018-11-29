# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7
import sys

k, l = map(int, sys.stdin.readline().strip().split())


def prime_factors(n):
    i = 2
    count = 0
    factors = []
    while i * i <= n:
        count += 1
        if n % i:
            i += 1
        else:
            n //= i
            factors.append(i)
    if n > 1:
        factors.append(n)
    return factors


def result():
    factors = prime_factors(k)
    min_factor = min(factors)
    for i in factors:
        if l <= i:
            return 'GOOD'
        else:
            return 'BAD %d' % min_factor


print result()