# /usr/bin/python
# -*- coding: utf-8 -*-


def double_to_binary(number):
    if number == 0.0: return '0'

    binary = []
    current_bit = 0.5 # 첫 번째 비트 : 1/2 = 0.5
    bits = 0

    while number != 0.0:
        if number >= current_bit:
            binary.append('1')
            number -= current_bit
        else:
            binary.append('0')

        # 비트 감소
        # 0.25      -> 1/4
        # 0.125     -> 1/8
        # 0.0078125 -> 1/16
        current_bit /= 2
        bits += 1

        if bits == 32: return ''.join(binary) + ' ERROR'
    return ''.join(binary)


def test(number):
    print "{}: {}".format(number, double_to_binary(number))


def main():
    test(0.95)
    test(0.75)
    test(0.32)
    test(0.234)
    test(0.2)
    test(0.1)
    test(1.0)


main()