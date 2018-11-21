# 문제: https://www.acmicpc.net/problem/1598
# 풀이: 주어진 숫자의 위치를 루프를 돌며 숫자판에서 찾아 거리를 계산

n1, n2 = map(int, input().split())
limit = max(n1, n2)
tmp = 1
for col in range(limit // 4 + 1):
    for row in range(4):
        if tmp == n1:
            find1 = col, row
        if tmp == n2:
            find2 = col, row
        tmp += 1
print(abs(find1[0] - find2[0]) + abs(find1[1] - find2[1]))
