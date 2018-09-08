# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

"""
https://www.acmicpc.net/problem/10211

- DP > Kadane's algorithm 사용 (O(n))
  : 배열의 연속 부분합 중 가장 큰 값을 O(N)시간 복잡도로 알아내는 알고리즘이다
"""


def max_subarray(x):
    maximum_ending = maximum_so_far = x[0]
    for i in x[1:]:
        maximum_ending = max(i, maximum_ending + i)
        maximum_so_far = max(maximum_so_far, maximum_ending)
    return maximum_so_far

"""
ending
1) 2 => 3
2) 3 => 6
3) 4 => 10
4) 5 => 15

so_far, ending
1) 1 => 3
2) 3 => 6
3) 6 => 10
4) 10 => 15
"""

n = raw_input().strip()
numbers = []
for i in range(int(n)):
    array_number = raw_input().strip()
    numbers.append(raw_input().split())

for number in numbers:
    print max_subarray(map(int, number))