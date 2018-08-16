# !/usr/bin/python
# -*- coding: utf-8 -*-

# 1.5 반복되는 문자 압축, 원래 문자열보다 길면 원래 문자열 그대로 반환하라


def compress(string):
    count = 0
    character = string[0]
    for char in string:
        if char == character[-1]:
            count += 1
        else:
            character += str(count) + char
            count = 1

    character + str(count)

    return character if len(character) <= len(string) else string


print compress('aaaabbcdeeee')
print compress('aaaab')
print compress('abcd')