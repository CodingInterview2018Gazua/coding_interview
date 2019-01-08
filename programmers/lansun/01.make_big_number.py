# /usr/bin/python
# -*- coding: utf-8 -*-
# python 3.3


def solution(number, k):
    answer = []
    start = 0
    while True:
        if k == len(number)-start:
            return ''.join(answer)
        elif k == 0:
            answer.append(number[start:])
            return ''.join(answer)

        window = number[start:start + k + 1]
        try:
            max_index = window.index('9')
        except:
            max_index = window.index(max(window))
        answer.append(window[max_index])
        start = start + max_index + 1
        k = k-max_index


print solution("1924", 2) == "94"
print solution("1231234", 3) == "3234"
print solution("4177252841", 4) == "775841"
