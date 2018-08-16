# !/usr/bin/python
# -*- coding: utf-8 -*-

# 1.6 이미지를 표현하는 MxN 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.
# 이때 이미지를 90도 회전시키는 메소드를 구현하라 (부가적인 행렬을 사용하지 않는다)


def rotation_matrix(m, n):
    matrix = [[0] * m for i in range(n)]
    #
    # for i in matrix:
    #     matrix[i] = i
    #
    # print matrix

    # a = [][]
    size = 3
    for i in range(size):
        for j in range(size):
            matrix[i][j] = i + j

    print matrix
    # character = string[0]
    # for char in string:
    #     if char == character[-1]:
    #         count += 1
    #     else:
    #         character += str(count) + char
    #         count = 1
    #
    # character + str(count)
    #
    # return character if len(character) <= len(string) else string


print rotation_matrix(4, 3)
