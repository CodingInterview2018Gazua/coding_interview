def to_num(x):
    result = 1
    for i, item in enumerate(x):
        result *= int(item)
    return result

N = input()
ans = False
for i in range(len(N)-1):
    x = N[:i+1]
    y = N[i+1:len(N)]
    if to_num(x) == to_num(y):
        ans = True
        break

print("YES" if ans else "NO")
