# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/14709
"""

# 여우 사인은 엄지손가락, 중지, 약지 세 손가락을 서로 끝이 맞닿도록 모으고,
# 검지와 새끼손가락은 다른 손가락과 닿지 않도록 곧게 펴서 여우의 얼굴과 두 귀를 표현한 손 모양이다.
# 1은 엄지손가락, 2는 검지, 3은 중지, 4는 약지, 5는 새끼손가락을 의미한다.


def fox_sign(numbers):
    fox_sign_number = [[1, 3], [1, 4], [3, 4]]
    cnt = 0
    for i in range(len(fox_sign_number)):
        for j in range(len(fox_sign_number[0])):
            if fox_sign_number[i][j] == numbers[i][j]:
                cnt += 1
    return cnt

count = raw_input('').strip()
count = int(count)
input_numbers = []
for i in range(count):
    try:
        finger = raw_input('').strip()
    except EOFError:
        break
    input_numbers.append(finger)

fingers = []
for i in range(count):
    fingers.append(map(int, str(input_numbers[i]).split(' ')))

print 'Wa-pa-pa-pa-pa-pa-pow!' if fox_sign(fingers) == count else 'Woof-meow-tweet-squeek'
