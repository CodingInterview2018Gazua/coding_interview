"""
문제: https://www.acmicpc.net/problem/2193
풀이: 다이나믹 프로그래밍
      자리수별 이친수의 개수를 계산하며 누적 저장
      N자리의 이친수 개수는 N-1자리 개수(0을 붙이는 경우) + N-2자리 개수(1을 붙이는 경우)이다.
      f(x) = f(x - 1) + f(x - 2)
"""

import sys
n = int(sys.stdin.readline())
count = [1, 1]
for i in range(2, n):
    count.append(count[i - 1] + count[i - 2])
print(count[n - 1])
