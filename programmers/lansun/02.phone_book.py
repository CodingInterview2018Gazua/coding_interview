# /usr/bin/python
# -*- coding: utf-8 -*-
# python 3.3


def solution(phone_book):
    answer = True
    phone_book = sorted(phone_book)
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]): answer = False
    return answer


def test(phone_book):
    print '{}'.format(solution(phone_book))


def main():
    test(['119', '97674223', '1195524421'])
    test(['12', '123', '1235', '567', '88'])

main()