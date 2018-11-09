# 문제: https://www.acmicpc.net/problem/1026
# 풀이: 문제에서 B는 재배열하면 안되고 A만 재배열하라고 했으니 말을 잘 듣도록 하자.
#       인덱스 배열을 만들어 B의 값에 대해 정렬하고, A는 인덱스 배열을 이용해 B의 값에 대해 역순 정렬한다.

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

idx = sorted([i for i in range(n)], key=lambda x: b[x])
a.sort(reverse=True)
sorted_a = [0 for _ in range(n)]
for i in range(n):
    sorted_a[idx[i]] = a[i]
print(sum([sorted_a[i] * b[i] for i in range(n)]))
