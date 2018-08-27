# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/6996
두 단어 A와 B가 주어졌을 때, A에 속하는 알파벳의 순서를 바꾸어서 B를 만들 수 있다면, A와 B를 애너그램이라고 한다.
두 단어가 애너그램인지 아닌지 구하는 프로그램을 작성하시오.
"""


def anagrams(word1, word2):
    same = True if sorted(word1) == sorted(word2) and len(word1) == len(word2) else False
    return '{} & {} are{} anagrams.'.format(word1, word2, '' if same else ' NOT')


count = raw_input('')
words = []
for input_word in range(int(count)):
    try:
        word = raw_input('')
    except EOFError:
        break
    words.append(word)

for word in words:
    word1, word2 = str(word).split(' ')
    print anagrams(word1, word2)