# -*- coding: utf-8 -*-


def brackets(open, close, s):
    if open == 0 and close == 0:
        print s
        return

    if open > 0: brackets(open-1, close+1, s + '(')
    if close > 0: brackets(open, close-1, s + ')')


def test(open, close, s):
    print '{}'.format(brackets(open, close, s))


def main():
    test(3, 0, '')
    print '--------'
    test(5, 0, '')


main()