# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/2527
"""

# for t in xrange(4):
#     result = 'a'
#     lists = map(int, raw_input().split())
#     rectangle_2 = lists[4:]
#     rectangle_1 = lists[:4]
#
#     x = max(rectangle_1[0], rectangle_2[0]) - min(rectangle_1[2], rectangle_2[2])
#     y = max(rectangle_1[1], rectangle_2[1]) - min(rectangle_1[3], rectangle_2[3])
#
#     if ((rectangle_1[0] == rectangle_2[2] and rectangle_1[1] == rectangle_2[3]) or
#         (rectangle_1[0] == rectangle_2[2] and rectangle_1[3] == rectangle_2[1]) or
#         (rectangle_1[2] == rectangle_2[0] and rectangle_1[3] == rectangle_2[1]) or
#         (rectangle_1[2] == rectangle_2[0] and rectangle_1[1] == rectangle_2[3])):
#         result = 'c'
#     elif x > 0 or y > 0:
#         result = 'd'
#     elif x == 0 or y == 0:
#         result = 'b'
#     else:
#         result = 'a'
#
# print result

n = 1
