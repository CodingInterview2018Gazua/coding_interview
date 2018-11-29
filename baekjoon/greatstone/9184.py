# 문제: https://www.acmicpc.net/problem/9184
# 풀이: Dynamic Programming. w 함수의 결과를 cache에 저장, 재활용하여 연산량을 줄인다.

from sys import stdin
cache = {}

def w(a, b, c):
    if (a, b, c) in cache:
        return cache[a, b, c]
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    elif a > 20 or b > 20 or c > 20:
        cache[20, 20, 20] = w(20, 20, 20)
        return cache[20, 20, 20]
    elif a < b and b < c:
        cache[a, b, c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        return cache[a, b, c]
    else:
        cache[a, b, c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
        return cache[a, b, c]

while True:
    a, b, c = map(int, stdin.readline().split())
    if a == b == c == -1:
        break
    print("w({}, {}, {}) = {}".format(a, b, c, w(a, b, c)))
