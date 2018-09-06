# /usr/bin/python
# -*- coding: utf-8 -*-


"""
다음 코드가 하는 일을 설명하라.
( (n & (n-1)) == 0 )
"""

"""
( (n & (n-1)) == 0 ) 은 1이 없는 비트를 의미한다

n	         n – 1	    n & (n – 1)
00000001	00000000	00000000
00000100	00000011	00000000
00010000	00001111	00000000

n에서 1을 빼면 비트 i는 0이 되고 모든 하위 비트는 1이 된다.
이제 n은 n-1, n & (n-1)와 공통된 1 비트가 없기 때문에 0이다

x & ~0 == 0 과 동일하다.
"""


def is_zero_bit(n):
    return int(n) & (int(n) - 1) == 0


def is_zero_bit2(n):
    return int(n) & ~0 == 0


def test(binary):
    print "{}: {} | {}".format(binary, is_zero_bit(binary), is_zero_bit2(binary))


def main():
    test('01000110')
    test('00000100')
    test('00000000')
    test('00011111')
    test('11111111')


main()