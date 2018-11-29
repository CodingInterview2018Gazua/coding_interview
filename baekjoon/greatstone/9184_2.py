# 문제: https://www.acmicpc.net/problem/9184
# 풀이: Python의 Memoization Decorator를 이용하여 w 함수 호출 결과를 재활용한다.

from sys import stdin

def memoize(func):
    memo = {}
    def memoizer(a, b, c):
        if (a, b, c) not in memo:            
            memo[a, b, c] = func(a, b, c)
        return memo[a, b, c]
    return memoizer

@memoize
def w(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    elif a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)
    elif a < b and b < c:
        return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
    else:
        return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)

while True:
    a, b, c = map(int, stdin.readline().split())
    if a == b == c == -1:
        break
    print("w({}, {}, {}) = {}".format(a, b, c, w(a, b, c)))
