# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/2954
"""


def revert_diary(words):
    vowels = 'aeiou' # 모음 
    vowels_patterns = [''.join([vowel, 'p', vowel]) for vowel in vowels]

    for i in range(len(vowels_patterns)):
        words = words.replace(vowels_patterns[i], vowels_patterns[i][:1])


    return words


words = raw_input('').strip()
words = words.split(' ')
result = []
for i in range(len(words)):
    result.append(revert_diary(words[i]))

print ' '.join(result)

