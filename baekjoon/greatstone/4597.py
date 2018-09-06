# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/4597
풀이: 입력 값의 1의 갯수가 짝수인지 홀수인지, 패리티가 e인지 o 인지에 따라 마지막 숫자를 결정
"""


def restore_bit_string(bit_string):
    bit1_cnt = bit_string.count("1")
    parity = bit_string[-1]
    if parity == 'e':
        if bit1_cnt % 2 == 0:
            return bit_string[0:-1] + '0'
        else:
            return bit_string[0:-1] + '1'
    else:
        if bit1_cnt % 2 == 0:
            return bit_string[0:-1] + '1'
        else:
            return bit_string[0:-1] + '0'


bitString = input()
while bitString != "#":
    print(restore_bit_string(bitString))
    bitString = input()
