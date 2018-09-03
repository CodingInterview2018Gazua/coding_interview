# /usr/bin/python
# -*- coding: utf-8 -*-


def set_bits(N, M, i, j):
    mask = (not 0) << (j + 1) | ((1 << i) - 1)

    return (N & mask) | (M << i)


N = 10000000000
M = 10011
i = 2
j = 6

print set_bits(N, M, i, j) # 40044