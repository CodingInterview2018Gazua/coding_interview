# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

# A의 제곱은 B의 제곱보다 N만큼 커 (1 ≤ N ≤ 1,000)
# 위의 힌트 조건을 만족하는 A와 B 쌍의 개수를 구하는 프로그램을 작성하시오.
# 상근이의 힌트 조건을 만족하는 (A,B) 쌍의 개수를 출력한다.

result = 0
end = 501
n = int(raw_input())
for b in range(1, end):
    for a in range(b, end):
        result += a ** 2 - b ** 2 == n
print result
