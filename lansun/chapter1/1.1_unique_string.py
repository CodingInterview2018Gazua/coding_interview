# !/usr/bin/python
# -*- coding: utf-8 -*-

# 1.1 문자열에 포함된 문자들이 전부 유일한지 검사하는 알고리즘을 구현하여라 다른 자료구조를 사용할 수 없다.
# ASCII Code


def is_unique_string(string):
    if len(string) > 256:
        return False

    string = string.strip()
    alphabet_a = 'a'
    if string.isupper():
        alphabet_a = 'A'

    checker = 0
    for char in string:
        value = ord(char) - ord(alphabet_a)
        shift = 1 << value

        if (checker & shift) > 0:
            return False

        checker |= shift

    return True

print is_unique_string("abcdef")
print is_unique_string("aff")
print is_unique_string("abcdeffff")
print is_unique_string("abcdeffff ")
print is_unique_string(" abcdef ")