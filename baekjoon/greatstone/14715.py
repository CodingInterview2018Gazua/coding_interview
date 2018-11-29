# 문제: https://www.acmicpc.net/problem/14715
# 풀이: 소인수 분해 후 각 소인수 지수의 합의 로그를 구한다.

import math

def get_prime_list(upper_bound):
    isPrime = [True for _ in range(upper_bound + 1)]
    for i in range(2, int(math.sqrt(upper_bound))):
        if isPrime[i]:
            for j in range(i * 2, upper_bound + 1, i):
                isPrime[j] = False 
    primes = []
    for i in range(2, upper_bound + 1):
        if isPrime[i]:
            primes.append(i)
    return primes

k = int(input())

primes = get_prime_list(k)

count = 0
for prime in primes:
    while k % prime == 0:
        k //= prime
        count += 1
    if k == 1:
        break
print(math.ceil(math.log2(count)))
