from sys import stdin
import collections
r, c = map(int, stdin.readline().split())
board = [list(map(lambda x: ord(x) - ord('A'), stdin.readline())) for _ in range(r)]
cache = [[0] * c for _ in range(r)]

direction = [(-1, 0), (0, 1), (0, -1), (1, 0)]
stack = []
stack.append((0, 0, 1 << board[0][0], 1))
max_len = 0
while stack:
    y, x, path, len = stack.pop()
    max_len = max(max_len, len)
    for dy, dx in direction:
        ny = y + dy
        nx = x + dx
        if ny < 0 or r <= ny or nx < 0 or c <= nx:
            continue
        
        n_pos = 1 << board[ny][nx]
        if cache[ny][nx] == path | n_pos:
            continue
        cache[ny][nx] = path | n_pos
        if path & n_pos == 0:
            stack.append((ny, nx, path | n_pos, len + 1))
            
print(max_len)
