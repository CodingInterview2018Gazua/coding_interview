# /usr/bin/python
# -*- coding: utf-8 -*-
# python 3.3

# 섞은 음식의 스코빌 지수 =
# 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

import heapq


def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0

    while scoville:
        top = heapq.heappop(scoville)

        if top >= K: break
        if len(scoville) == 0: return -1

        next = heapq.heappop(scoville)
        heapq.heappush(scoville, top + (next * 2))

        answer += 1

    return answer


print solution([1, 2, 3, 9, 10, 12], 7)

