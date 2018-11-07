# 문제: https://www.acmicpc.net/problem/6159
# 풀이: 바이너리 서치를 이용해 선택한 소와 함께 코스튬에 들어갈 수 있는 소의 수를 센다.

import bisect
n, s = map(int, input().split())
cows = [int(input()) for _ in range(n)]
sorted_cows = sorted(cows)
count = 0
for i in range(n):
    pos = bisect.bisect(sorted_cows, s - sorted_cows[i])
    if i < pos: 
        count += pos - i - 1
print(count)
