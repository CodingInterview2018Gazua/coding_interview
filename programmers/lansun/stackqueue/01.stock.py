# /usr/bin/python
# -*- coding: utf-8 -*-
# python 3.3


def solution(prices):
    answer = []
    duration_time = 0
    for i in range(len(prices)):
        base = prices[i]
        for j in range(i, len(prices) - 1):
            if base <= prices[j]:
                duration_time += 1

        answer.append(duration_time)
        duration_time = 0

    return answer


print solution([498, 501, 470, 489])
