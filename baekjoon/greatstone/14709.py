#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
문제: https://www.acmicpc.net/problem/14709
풀이: (1, 3), (4, 3), (1, 4) 가 들어오면 여우 사인 (입력 순서, 쌍의 순서 바뀔 수 있음)
     그 외 다른 모든 입력은 여우 사인 아님
"""


def check_fox_sign(input_list):
    if not [1, 3] in input_list and not [3, 1] in input_list:
        return False
    elif not [4, 3] in input_list and not [3, 4] in input_list:
        return False
    elif not [1, 4] in input_list and not [4, 1] in input_list:
        return False
    else:
        return True


nmrLine = int(input())
inputList = []
for i in range(0, nmrLine):
    inputList.append(list(map(int, input().split())))

if nmrLine == 3 and check_fox_sign(inputList):
    print("Wa-pa-pa-pa-pa-pa-pow!")
else:
    print("Woof-meow-tweet-squeek")
