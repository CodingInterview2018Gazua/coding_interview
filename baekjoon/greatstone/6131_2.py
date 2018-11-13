# 문제: https://www.acmicpc.net/problem/6131
# 풀이: 1 ~ 500 사이의 B에 대해 루트(B의 제곱 + N)가 정수이면 카운트

n = int(input())
count = 0
for b in range(1, 500):
    a = int((b*b + n) ** 0.5)
    if b*b + n == a*a:
        count += 1
print(count)
