# 문제: https://www.acmicpc.net/problem/7576
# 풀이: BFS를 이용해 확장하며 가장 멀리 있는 토마토를 찾는다.

from sys import stdin
import queue

m, n = map(int, stdin.readline().split())
box = [[-1 for _ in range(m + 2)]]
for _ in range(n):
    line = [-1]
    line.extend([int(x) for x in stdin.readline().split()])
    line.append(-1)
    box.append(line)
box.append([-1 for _ in range(m + 2)])

q = queue.deque()
for col in range(1, m + 1):
    for row in range(1, n + 1):
        if box[row][col] == 1:
            q.append((row, col))

while q:
    r, c = q.popleft()
    result = box[r][c]
    if box[r - 1][c] == 0:
        box[r - 1][c] = box[r][c] + 1
        q.append((r - 1, c))
    if box[r + 1][c] == 0:
        box[r + 1][c] = box[r][c] + 1
        q.append((r + 1, c))
    if box[r][c - 1] == 0:
        box[r][c - 1] = box[r][c] + 1
        q.append((r, c - 1))
    if box[r][c + 1] == 0:
        box[r][c + 1] = box[r][c] + 1
        q.append((r, c + 1))

print(result - 1 if all(0 not in row for row in box) else -1)
