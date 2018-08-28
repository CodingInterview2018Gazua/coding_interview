# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/1718
"""

import string


def vigenere_cipher(words, encrypt):
    encrypt_words = []
    alphabets = list(string.ascii_lowercase) * 2

    for i in range(len(list(words))):
        char = words[i]

        if char is not ' ':
            char_ord = ord(words[i]) - ord('a')
            key = ord(encrypt[i % len(encrypt)]) - 96 # loveove
            result = char_ord - key + 26 if char_ord - key < ord('a') else char_ord - key
            encrypt_words.append(alphabets[result])
        else:
            encrypt_words.append(' ')

    return ''.join(encrypt_words)


words = raw_input().strip()
encrypt = raw_input().strip()
print vigenere_cipher(words, encrypt)