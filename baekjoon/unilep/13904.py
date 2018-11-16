from heapq import _heappop_max, _heapify_max

MAX = 1001
N = int(input())
A = [None] * MAX
mx = 0
for _ in range(N):
    K, W = map(int, input().split())
    if not A[K]:
        A[K] = list()
    A[K].append(W)
    mx = max(mx, K)

sum = 0
ans = []
for i in reversed(range(1, mx+1)):
    if A[i]:
        for j in range(len(A[i])):
            ans.append(A[i][j])
            _heapify_max(ans)
    if ans:
        sum += ans[0]
        _heappop_max(ans)

print(sum)
