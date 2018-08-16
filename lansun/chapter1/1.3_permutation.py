# !/usr/bin/python
# -*- coding: utf-8 -*-

# 1.3 문자열 두 개를 입력받아 그 중 하나가 다른 하나의 순열인지 판별하는 메소드를 만들어라


def is_permutaion(string1, string2):
    if len(string1) != len(string2):
        return False

    string1 += string1
    return True if string2 in string1 else False


print is_permutaion('abc', 'bca')
print is_permutaion('abc', 'cba')
print is_permutaion('abc', 'cab')
