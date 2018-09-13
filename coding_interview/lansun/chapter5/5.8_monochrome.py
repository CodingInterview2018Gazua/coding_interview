# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

PIXEL_BITS = 8


def get_byte(y, width, x):
    return y * (width / PIXEL_BITS) + x / PIXEL_BITS


def draw_line(screen, width, x1, x2, y):
    start_byte = get_byte(y, width, x1)
    end_byte = get_byte(y, width, x2)

    for i in range(start_byte, (end_byte + 1)):
        if i == start_byte:
            screen[i] = 0b11111111 >> (x1 % PIXEL_BITS)
        elif i == end_byte:
            screen[i] = 0b11111111 << (7 - (x2 % PIXEL_BITS))
        else:
            screen[i] = 0b11111111

    for i in range(len(screen)):
        if screen[i] != 0:
            return 'byte {} : {} '.format(i, bin(screen[i]).replace('0b', ''))


print draw_line([0] * 96, 16, 2, 9, 8)