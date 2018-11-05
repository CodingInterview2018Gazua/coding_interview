'''
문제: https://www.acmicpc.net/problem/1149
풀이: 다이나믹 프로그래밍.
     x번째 집을 빨강으로 칠할 때의 최소 비용을 f(x), 초록으로 칠할 때의 최소 비용을 g(x), 파랑으로 칠할 때의 최소 비용을 h(x)라고 정의할 때
     f(x) = min(g(x - 1), h(x - 1)) + r_cost(x)
     g(x) = min(f(x - 1), h(x - 1)) + g_cost(x)
     h(x) = min(f(x - 1), g(x - 1)) + h_cost(x)
     를 각각 계산하여 저장하고 활용한다.
'''

import sys
n = int(sys.stdin.readline())
costs = []
for _ in range(n):
    costs.append(list(map(int, sys.stdin.readline().split())))
accum = [[0, 0, 0]]
for i in range(n):
    comp = []
    comp.append(costs[i][0] + min(accum[i][1], accum[i][2]))
    comp.append(costs[i][1] + min(accum[i][0], accum[i][2]))
    comp.append(costs[i][2] + min(accum[i][0], accum[i][1]))
    accum.append(comp)
print(min(accum[n]))
