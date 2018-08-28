# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/6996
두 단어 A와 B가 주어졌을 때, A에 속하는 알파벳의 순서를 바꾸어서 B를 만들 수 있다면, A와 B를 애너그램이라고 한다.
두 단어가 애너그램인지 아닌지 구하는 프로그램을 작성하시오.
"""

import string


def vigenere_cipher(words, key):
    encrypt_words = []
    alphabet = list(string.ascii_lowercase)
    alphabets = alphabet * 2
    alphabets_length = len(alphabet)

    for i in range(len(list(words))):
        char = words[i]

        if char is not ' ':
            minus = ord(key[i % len(key)]) - (ord('a') - 1)
            minus_index = alphabets.index(char)
            result = (minus_index - minus + alphabets_length) if minus_index - minus < ord('a') else minus_index - minus
            encrypt_words.append(alphabets[result])
        else:
            encrypt_words.append(' ')

    return ''.join(encrypt_words)


words = 'nice day'
encrypt = 'love'
print vigenere_cipher(words, encrypt)
# print encrypt, alphabets.index(encrypt) % len(encrypt_keys)

# print alphabets.index('n') + alphabets.index(i) + 1
#     print alphabets[1:-alphabets.index(j) + alphabets.index(i) + 1]
