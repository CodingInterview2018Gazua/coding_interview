# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/3449
"""


def hamming_distance(bin1, bin2):
    return 'Hamming distance is {}.'.format(sum(x != y for x, y in zip(bin1, bin2)))


count = raw_input('').strip()
words = []
for input_word in range(int(count) * 2):
    try:
        word = raw_input('').strip()
    except EOFError:
        break
    words.append(word)

for i in range(0, len(words), 2):
    if i < len(words) - 1:
        print hamming_distance(words[i], words[i+1])
    i += 3