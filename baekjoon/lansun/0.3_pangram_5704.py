# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/5704
"""

import string


def is_pangram(words):
    return 'Y' if all(x in words for x in list(string.ascii_lowercase)) else 'N'


input_list = []
while True:
    words = raw_input()
    if words == '*': break
    input_list.append(words)

for input in input_list:
    print is_pangram(input)