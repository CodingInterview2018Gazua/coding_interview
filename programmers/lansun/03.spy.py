# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

"""
의상의 종류를 counting 하여 ([1, 2]) 그 길이만큼 루프돌아 +1 을 answer에 넣어 리턴
"""
from collections import Counter


def solution(clothes):
    closthes_type_count = Counter([x[1] for x in clothes]).values()
    answer = 1
    for count in closthes_type_count:
        answer *= count + 1

    return answer - 1


def test(clothes):
    print '{}'.format(solution(clothes))


def main():
    test([['yellow_hat', 'headgear'], ['blue_sunglasses', 'eyewear'], ['green_turban', 'headgear']])
    test([['crow_mask', 'face'], ['blue_sunglasses', 'face'], ['smoky_makeup', 'face']])

main()

