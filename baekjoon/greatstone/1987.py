from sys import stdin
import collections
r, c = map(int, stdin.readline().split())
board = [stdin.readline() for _ in range(r)]
cache = [[''] * c for _ in range(r)]

direction = [(-1, 0), (0, 1), (0, -1), (1, 0)]
stack = []
stack.append((0, 0, board[0][0]))
max_len = 1
while stack:
    y, x, path = stack.pop()
    for dy, dx in direction:
        ny = y + dy
        nx = x + dx
        if ny < 0 or r <= ny or nx < 0 or c <= nx:
            continue
        if board[ny][nx] in path:
            continue
        if cache[ny][nx] == path + board[ny][nx]:
            continue
        cache[ny][nx] = path + board[ny][nx]
        stack.append((ny, nx, path + board[ny][nx]))
        max_len = max(max_len, len(path) + 1)

print(max_len)
