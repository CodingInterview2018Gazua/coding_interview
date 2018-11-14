dx = [0, 0, 1, 1]
dy = [0, 1, 0, 1]


def func(x, y, sz, cnt, r, c):
    if sz == 1:
        if x == r and y == c:
            print(cnt)
        return
    k = sz // 2
    global dx, dy
    for i in range(4):
        if x + dx[i] * k <= r < x + (dx[i] + 1) * k and y + dy[i] * k <= c < y + (dy[i] + 1) * k:
            func(x + dx[i] * k, y + dy[i] * k, k, cnt + i * k * k, r, c)


N, r, c = map(int, input().split())
N = 2 ** N
func(0, 0, N, 0, r, c)
