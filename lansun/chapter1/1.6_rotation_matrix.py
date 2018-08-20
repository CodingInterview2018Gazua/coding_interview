# !/usr/bin/python
# -*- coding: utf-8 -*-

# 1.6 이미지를 표현하는 NxN 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.
# 이때 이미지를 90도 회전시키는 메소드를 구현하라 (부가적인 행렬을 사용하지 않는다)


def rotation_matrix(n):
    matrix = [[0] * n for i in range(n)]
    for i in xrange(n):
        for j in xrange(n):
            matrix[i][j] = i + j

    return matrix, zip(*matrix[::-1])


matrix, rotation_matrix = rotation_matrix(4)
print "original matrix   >>>>>\n",
for i in matrix:
    print i

    # original matrix   >>>>>
    # [0, 1, 2, 3]
    # [1, 2, 3, 4]
    # [2, 3, 4, 5]
    # [3, 4, 5, 6]

print "rotation matrix   >>>>>\n",
for i in rotation_matrix:
    print list(i)

    # rotation matrix   >>>>>
    # [3, 2, 1, 0]
    # [4, 3, 2, 1]
    # [5, 4, 3, 2]
    # [6, 5, 4, 3]
