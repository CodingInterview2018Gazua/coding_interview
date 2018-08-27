# !/usr/bin/python
# -*- coding: utf-8 -*-

# 1.2 널 문자열로 끝나는 문자열을 뒤집는 reverse 함수를 구현하라


def reverse1(string):
    return string[::-1].strip() if string[-1] == ' ' else string


def reverse2(string):
    return ''.join(reversed(string.strip())) if string[-1] == ' ' else string


def reverse3(string):
    if string[-1] == ' ':
        reverse_string = []
        string_list = list(string)
        while string_list:
            reverse_string.append(string_list.pop(-1))

        return ''.join(reverse_string).strip()
    else:
        return string

print reverse1('abc ')
# cba

print reverse2('cicao pizza ')
# azzip oacic

print reverse3('go for it')
# go for it