# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

"""
시간복잡도 O(n), 공간복잡도 O(n)
cache dict 에 recursion을 저장
"""

stairs = {1: 1, 2: 2}
def upstair_count(n):
    if n == 0: return 1
    if n not in stairs:
        stairs[n] = upstair_count(n - 1) + upstair_count(n - 2) + upstair_count(n - 3)

    return stairs[n]


def test(n):
    print "{} : {}".format(n, upstair_count(n))


def main():
    # test(3)
    test(5)
    test(10)
    test(100)


main()

