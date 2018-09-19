# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

from itertools import chain, combinations


def powerset(n):
    n = list(n)
    for r in range(len(n) + 1):
        print s,r, combinations(n, r)
    return chain.from_iterable(combinations(n, r) for r in range(len(n) + 1))


def subsets(n):
    return map(list, powerset(n))


def test(n):
    print '{}'.format(subsets(n))


def main():
    test([1, 2, 3])
    test(['a', 'b', 'c'])


main()
