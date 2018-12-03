N = int(input())
A = []
for _ in range(N):
    a, b = map(int, input().split())
    A.append({'cnt':a, 'score':b})
A = sorted(A, key=lambda a: (-a['cnt'], a['score']))
ans = 0
for i, item in enumerate(A):
    if i < 5:
        pre = item
        continue
    if pre['cnt'] == item['cnt']:
        if pre['score'] < item['score']:
            ans += 1
        pre = item
    else:
        break

print(ans)
