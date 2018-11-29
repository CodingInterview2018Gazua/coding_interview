# 문제: https://www.acmicpc.net/problem/1598
# 풀이: 주어진 숫자의 위치를 수식으로 계산

n1, n2 = map(int, input().split())
n1_row = (n1 - 1) % 4
n1_col = (n1 - 1) // 4
n2_row = (n2 - 1) % 4
n2_col = (n2 - 1) // 4
print(abs(n1_row - n2_row) + abs(n1_col - n2_col))
