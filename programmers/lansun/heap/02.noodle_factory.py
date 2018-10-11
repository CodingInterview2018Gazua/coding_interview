# /usr/bin/python
# -*- coding: utf-8 -*-
# python 3.3

import heapq


def solution(stock, dates, supplies, k):
    answer, start = 0, 0
    result = []

    while stock < k:
        for i in range(start, len(dates)):
            if dates[i] <= stock:
                heapq.heappush(result, -supplies[i])
            else:
                start = i
                break

        answer += 1
        stock += -heapq.heappop(result)

    return answer


print solution(4, [4, 10, 15], [20, 5, 10], 30)