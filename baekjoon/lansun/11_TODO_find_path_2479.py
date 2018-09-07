# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/2479
"""

# TODO 미완성


def hamming_distance(bin1, bin2):
    # print 'Hamming distance is {}.'.format(sum(x != y for x, y in zip(bin1, bin2)))
    x = int(bin1) ^ int(bin2)
    print x,  int(bin1), int(bin2)
    return sum(x != y for x, y in zip(bin1, bin2))

aa = ['000', '111', '010', '110', '001']

paths = {}
for index, a in enumerate(aa):
    for b in aa[index+1:]:
        paths[index] = hamming_distance(a, b)

print paths

# bit_strings = []
# while True:
#     words = raw_input()
#     if words == '#': break
#     bit_strings.append(words)
#
# for bit_string in bit_strings:
#     print replace_bit_string(bit_string)
#
