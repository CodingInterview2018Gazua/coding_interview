# 문제: https://www.acmicpc.net/problem/6131
# 풀이: 1 ~ 500 사이의 A에 대해 1 ~ A 사이의 루프를 돌며 조건을 만족하는 B를 찾아 카운트

n = int(input())
count = 0
for a in range(1, 500):
    for b in range(1, a):
        diff = a*a - b*b
        if diff < n:
            break
        elif diff == n:
            count += 1 
print(count)
