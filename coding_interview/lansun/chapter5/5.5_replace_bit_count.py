# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7


# XOR
def replace_bit_count(a, b):
    c = a ^ b
    count = 0
    while c:
        count += c & 1
        c >>= 1

    return count


def test(a, b):
    print "{}, {} : {}".format(a, b, replace_bit_count(a, b))


def main():
    test(31, 14)
    test(20, 10)
    test(13, 9)
    test(7, 10)
    test(10, 20)


main()