# /usr/bin/python
# -*- coding: utf-8 -*-
# python 3.3

from heapq import *


def solution(stock, dates, supplies, k):
    answer, start = 0, 0
    result = []

    while stock < k:
        for i in range(start, len(dates)):
            if dates[i] <= stock:
                heappush(result, -supplies[i])
                print result
            else:
                start = i
                break

        answer += 1
        stock += -heappop(result)

    return answer


# solution(4, [4, 10, 15], [20, 10, 5], 30)

lists = [3, 4, 5, 2, 1]
# lists = [1, 2, 3, 4, 5]
heapify(lists)
result = []
result2 = []
stock = 4
while lists:
    for i in range(len(lists)):
        heappush(result, -lists[i])
        print "push 1 : ", result
        print -heappop(result)

        # stock += -heappop(result)

        # print stock
    if i > 1:
        break

# t1 = 5
# t2 = 4
#
# def __add__(n):
#     return n - n
#
# print t1.__add__(t2)