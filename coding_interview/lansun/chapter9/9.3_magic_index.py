# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7
import sys

sys.setrecursionlimit(10000)


def find_magic_index_by_brute_force(n):
    for i in range(len(n)):
        if i == n[i]: return i


def find_magic_index_by_recursive(n, start, end):
    if start > end: return -1

    mid = (start + end) / 2

    mid_value = n[mid]
    if mid_value == mid: return mid

    left = min(mid - 1, mid_value)
    left_rec = find_magic_index_by_recursive(n, start, left)
    if left_rec >= 0: return left_rec

    right = max(mid + 1, mid_value)
    return find_magic_index_by_recursive(n, right, end)


def test(n):
    print 'brute force magic index : {}'.format(find_magic_index_by_brute_force(n))
    print 'recursive   magic index : {}'.format(find_magic_index_by_recursive(n, 0, len(n) - 1))
    print '---------'


def main():
    test([-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13])
    test([0, 1, 2, 3, 4, 5, 10, 10, 11])
    test([-10, -5, 1, 1, 1, 4, 5, 9, 10, 10, 10])
    test([1, 2, 3, 3, 3, 4, 5, 9, 10, 10, 11])


main()
