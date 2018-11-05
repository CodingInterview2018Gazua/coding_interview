#문제: https://www.acmicpc.net/problem/6236
#풀이: 이진 탐색을 이용해 K를 구한다.
#      low, high 초기값은 하루 사용 금액 중 최대 값, 하루 사용 금액 총 합으로 설정한다.
#      이진 탐색 시 k원을 변화하며 문제에 따라 계산했을 때 
#      m번 이상 인출하는 경우 low를 상향하고, m번 이하 인출하는 경우 high를 하향하며
#      low와 high가 같아질 때까지 찾는다.

import sys
n, m = map(int, sys.stdin.readline().split())
costs = [int(sys.stdin.readline()) for _ in range(n)]

low = max(costs)
high = sum(costs)
while low != high:
    count = 0
    k = 0
    for cost in costs:
        if k < cost:
            k = (low + high) // 2
            count += 1
        k -= cost
    if count > m:
        low = (low + high) // 2 + 1
    else:
        high = (low + high) // 2
print(low)
