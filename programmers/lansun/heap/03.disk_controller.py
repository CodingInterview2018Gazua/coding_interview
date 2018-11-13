# /usr/bin/python
# -*- coding: utf-8 -*-
# python 3.3

"""
- 0ms 시점에 3ms가 소요되는 A작업 요청
- 1ms 시점에 9ms가 소요되는 B작업 요청
- 2ms 시점에 6ms가 소요되는 C작업 요청

- A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
- B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
- C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)

이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.


"""
from heapq import *

answer = 0
time = 0
current_job = []
queue = []
jobs = [[0, 3], [1, 9], [2, 6]]

heapify(jobs)
#
# while jobs:
#     temp = heappop(jobs)
#     current_job = [temp[1], temp[0]]
#     # print temp, current_job, current_job[1]

# print (((0+3) + (3+9)-1 + (3+9)+6)-2)/3
# print (((0+3) + (3+6)-1 + (3+6)+9)-2)/3

jobs.sort(key=lambda x: x[0], reverse=True)
completed = 0
heap = []
time = 0
nums = len(jobs)

while jobs:
    while jobs and jobs[-1][0] <= time:
        start, duration = jobs.pop()
        heappush(heap, (duration, start))

    if not heap:
        start, duration = jobs.pop()
        heappush(heap, (duration, start))
        time = start

    duration, start = heappop(heap)
    time += duration
    completed += time - start

while heap:
    duration, start = heappop(heap)
    time += duration
    completed += time - start


# print int(completed / nums)

age = 30
while True:
    if age >= 50:
        status = '교촌치킨 개업'
        print age, status
        break
    else:
        status = '이직'
        print age, status

    age += 1