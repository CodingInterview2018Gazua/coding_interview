# !/usr/bin/python
# -*- coding: utf-8 -*-

# 1.7 M x N 행렬의 한 원소가 0일 경우 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 만들어라


def replace_matrix1(m, n):
    matrix = [[0] * m for i in range(n)]

    for i in range(n)        :
        for j in range(n):
            matrix[i][j] = i * j

    output_matrix(matrix)

    for x in range(len(matrix)):
        for y in range(len(matrix[x])):
            if matrix[y][x] == 0:
                matrix[y][x] = True

    for x in range(len(matrix)):
        for y in range(len(matrix[x])):
            if matrix[y][x]:
                matrix[y][x] = 0

    return matrix


def replace_matrix2(matrix):
    col_rows = len(matrix) * [len(matrix) * [False]]

    matrix_size = len(matrix)
    for i in range(matrix_size):
        for j in range(len(matrix[i])):
            if matrix[j][i] == 0:
                col_rows[j][i] = True

    output_matrix(matrix)

    for i in range(matrix_size):
        for j in range(len(matrix[i])):
            if col_rows[j][i]:
                matrix[j][i] = matrix[i][j] = 0

    return matrix


def output_matrix(matrix):
    print "original matrix   >>>>>\n",
    for i in matrix:
        print list(i)


matrix = replace_matrix1(4, 4)
print "rotation matrix   >>>>>\n",
for i in matrix:
    print list(i)

print "=================================="
matrix = replace_matrix2([[1, 2, 3, 4],
     [5, 6, 0, 8],
     [9, 0, 11, 12],
     [13, 14, 15, 16]])

print "rotation matrix   >>>>>\n",
for i in matrix:
    print list(i)
