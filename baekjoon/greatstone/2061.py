import math

def get_primes(upper_bound):
    if upper_bound < 2:
        return []
    isPrime = [True for _ in range(upper_bound + 1)]
    for i in range(2 * 2, int(math.sqrt(upper_bound)), 2):
        isPrime[i] = False 
    for i in range(3, int(math.sqrt(upper_bound)), 2):
        if isPrime[i]:
            for j in range(i * i, upper_bound + 1, i * 2):
                isPrime[j] = False 
    primes = [2]
    for i in range(3, upper_bound + 1, 2):
        if isPrime[i]:
            primes.append(i)
    return primes

k, l = map(int, input().split())
primes = get_primes(l - 1)
for prime in primes:
    if k % prime == 0:
        print("BAD " + str(prime))
        break
else:
    print("GOOD")
