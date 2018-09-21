# /usr/bin/python
# -*- coding: utf-8 -*-
# python 3.3

from collections import Counter


def solution(participant, completion):
    answer = Counter(participant) - Counter(completion)
    return list(answer.keys())[0]


def test(participant, completion):
    print '{}'.format(solution(participant, completion))


def main():
    test(['leo', 'kiki', 'eden'], ['eden', 'kiki'])
    test(['marina', 'josipa', 'nikola', 'vinko', 'filipa'], ['josipa', 'filipa', 'marina', 'nikola'])
    test(['mislav', 'stanko', 'mislav', 'ana'], ['stanko', 'ana', 'mislav'])

main()