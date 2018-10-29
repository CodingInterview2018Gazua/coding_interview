"""
문제: https://www.acmicpc.net/problem/2600
풀이: Dynamic Programing.
     현재 상태에서 공을 꺼냈을 때 상대가 지게 만드는 상태로 이동할 수 있다면 승리하는 상태로 태깅
"""

b = list(map(int, input().split()))

n = 501
dp = [[False for _ in range(n)] for _ in range(n)]
for i in range(n):
    for j in range(n):
        for bn in b:
            if (j - bn >= 0 and not dp[i][j - bn]) \
                    or (i - bn >= 0 and not dp[i - bn][j]):
                dp[i][j] = True

for _ in range(5):
    k1, k2 = map(int, input().split())
    if dp[k1][k2]:
        print('A')
    else:
        print('B')
