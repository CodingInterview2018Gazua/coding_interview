# !/usr/bin/python
# -*- coding: utf-8 -*-

# 1.8 한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubstring이라는 메소드가 있다고 하자
# s1과 s2의 두 문자열이 주어졌을 때 s2가 s1을 회전시킨 결과인지 판별하는 코드를 isSubstring을 한번만 호출하도록 작성하여라
# 가령 'waterbottle'은 'erbottlewat'을 회전시켜 얻을 수 있는 문자열이다


def is_substring(word1, word2):
    return True if word2 in word1 else False


def is_rotation_words(word1, word2):
    if len(word1) != len(word2):
        return False

    word1 += word1
    return is_substring(word1, word2)


print is_rotation_words(word1='waterbottle', word2='erbottlewat')        # True
print is_rotation_words(word1='waterbottle', word2='erbottlwwat')        # False
print is_rotation_words(word1='waterbottle', word2='rbottlewate')        # True
print is_rotation_words(word1='waterbottle', word2='lewaterbo # Truett') # True
print is_rotation_words(word1='appple', word2='ppleap')                  # True
print is_rotation_words(word1='appple', word2='ppplea')                  # True