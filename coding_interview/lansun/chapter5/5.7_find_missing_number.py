# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7


def find_missing_number(A):
    n = len(A)
    x1 = A[0]
    x2 = 1
    # 모든 요소를 XOR 하고 XOR의 결과를 X1로 할당
    for i in range(n):
        x1 ^= A[i]

    # 1에서 n 까지의 모든 숫자를 XOR로 하고, 그 XOR을 X2로 할당
    for i in range(n+2):
        x2 ^= i

    # x1과 x2의 XOR은 누락된 번호를 return
    return x1 ^ x2


def test(x):
    print "{} : {}".format(x, find_missing_number(x))


def main():
    test([1, 2, 3, 4, 6, 7, 8, 9, 10])
    test([1, 2, 3, 5])


main()

