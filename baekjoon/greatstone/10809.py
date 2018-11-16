# 문제: https://www.acmicpc.net/problem/10809
# 풀이: 구현 문제

import sys
from string import ascii_lowercase

s = sys.stdin.readline().rstrip()
answer = []
for c in ascii_lowercase:
    answer.append(s.find(c))
print(*answer)
