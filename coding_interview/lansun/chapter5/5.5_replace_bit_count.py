# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7


def number_to_binary(x):
    return bin(x).replace('0b', '')


def replace_bit_count(a, b):
    a = number_to_binary(a)
    b = number_to_binary(b)

    return sum(x != y for x, y in zip(a, b)) + (len(a) - len(b))


def test(a, b):
    print "{}, {} : {}".format(a, b, replace_bit_count(a, b))


def main():
    test(31, 14)
    test(20, 10)
    test(5, 3)
    test(6, 4)
    test(0, -1)


main()