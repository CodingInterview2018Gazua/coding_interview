# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/4597
- 1의 개수가 홀수개 : 홀수 패리티
- 1의 개수가 짝수개 : 짝수 패리티
- 1이 없는 0      : 짝수 패리티

e : even
o : odd
"""


def replace_bit_string(bit_string):
    last = bit_string[-1:]
    others = bit_string[:-1]
    once_count = others.count('1')

    if last == 'e':
        others += '0' if is_event(once_count) else '1'
    elif last == 'o':
        others += '0' if not is_event(once_count) else '1'

    return others


def is_event(number):
    return number % 2 == 0


bit_strings = []
while True:
    words = raw_input()
    if words == '#': break
    bit_strings.append(words)

for bit_string in bit_strings:
    print replace_bit_string(bit_string)

