# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/2662
풀이: Dynamic Programming 적용.
     순차적으로 회사 별 남은 투자 금액에 대한 최대 이익을 백트래킹으로 찾으면서
     이미 찾은 최대 이익은 저장해 두었다가 재활용한다.
     max_profits 은 남은 금액 x 회사의 최대 이익을 저장하는 배열
     max_profits[n][m]에는 n 만원이 남았을 때 m 회사 이후로 투자할 수 있는 방법 중 가장 큰 이익을 저장한다.
     amounts 는 같은 방식으로 가장 큰 이익일 때 사용하는 금액을 저장한다.
"""


def find_max_profit(remains, company):
    if max_profits[remains][company] == -1:
        max_profit = 0
        amount = 0
        for i in range(remains):
            profit = profits[i][company + 1] + find_max_profit(remains - i, company + 1)
            if max_profit < profit:
                max_profit = profit
                amount = i
        max_profits[remains][company] = max_profit
        amounts[remains][company] = amount
    return max_profits[remains][company]


n, m = map(int, input().split())

profits = [[0 for _ in range(m + 1)]]
for _ in range(n):
    profits.append(list(map(int, input().split())))

max_profits = [[-1 for _ in range(m)] for _ in range(n + 1)]
amounts = [[0 for _ in range(m)] for _ in range(n + 1)]
for i in range(n + 1):
    max_profits[i][m - 1] = profits[i][m]
    amounts[i][m - 1] = i
print(find_max_profit(n, 0))
result = ""
find_amount = n
for i in range(m):
    result += str(amounts[find_amount][i]) + " "
    find_amount -= amounts[find_amount][i]
print(result)
