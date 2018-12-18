# 문제: https://www.acmicpc.net/problem/1356
# 풀이: 루프를 돌며 앞과 뒤를 분리해 자리수의 곱을 계산하고 같은 경우가 있다면 유진수

def f(s):
    multiply = 1
    for c in s:
        multiply *= int(c)
    return multiply

n = input().rstrip()
for i in range(1, len(n)):
    left, right = n[:i], n[i:]
    if f(left) == f(right):
        print("YES")
        break
else:
    print("NO")
