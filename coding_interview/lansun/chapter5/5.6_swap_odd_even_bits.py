# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

"""
32bit 기준
"""


def swap_odd_even_bits(x):
    # 0xAAAAAAAA는 32 비트 수이며 모든 짝수 비트는 1로 설정되고 모든 홀수 비트는 0으로 설정
    even_bits = x & 0xAAAAAAAA

    # 0x55555555는 모든 홀수 비트가 1로 설정되고 모든 짝수 비트가 0으로 설정
    odd_bits = x & 0x55555555

    # 오른쪽으로 짝수 비트 shift
    even_bits >>= 1

    # 왼쪽으로 홀수 비트 shift
    odd_bits <<= 1

    # 홀수 | 짝수 컴바인
    return even_bits | odd_bits


def test(x):
    print "{} : {}".format(x, swap_odd_even_bits(x))


def main():
    test(23)
    test(30)
    test(5)


main()

