# 문제: https://www.acmicpc.net/problem/14696
# 풀이: 누가누가 코딩 잘하나

from sys import stdin
from collections import Counter

n = int(stdin.readline())

for _ in range(n):
    count_a = Counter(list(map(int, stdin.readline().split()[1:])))
    count_b = Counter(list(map(int, stdin.readline().split()[1:])))

    for shape in range(4, 0, -1):
        if count_a[shape] > count_b[shape]:
            print('A')
            break
        elif count_a[shape] < count_b[shape]:
            print('B')
            break
    else:
        print('D')
