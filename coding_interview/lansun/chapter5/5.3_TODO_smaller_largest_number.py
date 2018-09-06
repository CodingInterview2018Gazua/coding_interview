# /usr/bin/python
# -*- coding: utf-8 -*-


# TODO 미완성


def get_once_bit_count(x):
    binary = bin(x).replace('0b', '')
    return binary, str(binary).count('1')


def get_max_min_by_x(x):
    binary, count = get_once_bit_count(x)
    print binary, count

    # x보다 작은 것 중 가장 큰 정수와
    # 가운데에서 1을 찾고, 그 다음 0->1 바꾼다 (오른쪽 -> 왼쪽)
    # 오른쪽에 있는 것을 끄기 1->0
    # 모든 1을 가능한 오른쪽으로 재배열하여 가능한한 작은 숫자를 만든다
    # middle = binary[:len(binary) / 2]

    # x보다 큰 것 중 가장 작은 정수를 찾아라

x = 145
print get_max_min_by_x(x)
