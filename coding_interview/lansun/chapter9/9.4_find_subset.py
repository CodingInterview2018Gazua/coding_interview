# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

from itertools import chain, combinations


def powerset(iterable):
    s = list(iterable)
    return chain.from_iterable(combinations(s, r) for r in range(len(s) + 1))


def subsets(s):
    return map(list, powerset(s))


def test(n):
    print '{}'.format(subsets(n))


def main():
    test([1, 2, 3])
    test(['a', 'b', 'c'])


main()
