# !/usr/bin/python
# -*- coding: utf-8 -*-

# 1.4 공백을 %20 으로 변환


def replace_space(string):
    string = string.strip()
    space = '%20'
    replace_string = []
    for char in string:
        replace_string.append(space if char == ' ' else char)

    return ''.join(replace_string)


print replace_space('Mr John Smith ')