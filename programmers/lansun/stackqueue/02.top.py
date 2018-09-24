# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7


def solution(heights):
    answer = []
    for i in range(len(heights)):
        result = 0
        for j in range(i):
            if heights[i] < heights[j]:
                result = j + 1
        answer.append(result)

    return answer


print solution(heights=[6, 9, 5, 7, 4])
print solution([3, 9, 9, 3, 5, 7, 2])
print solution([1, 5, 3, 6, 7, 6, 5])