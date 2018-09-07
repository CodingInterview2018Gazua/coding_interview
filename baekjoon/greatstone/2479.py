# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
"""


def hamming_distance(a, b):
    dist = 0
    for c1, c2 in zip(a, b):
        if c1 != c2:
            dist += 1
    return dist


n, k = map(int, input().split())
binary_string = [input() for _ in range(n)]
start, end = map(int, input().split())
start -= 1
end -= 1

connected = [[] for _ in range(n)]
for i in range(n):
    for j in range(i + 1, n):
        if hamming_distance(binary_string[i], binary_string[j]) == 1:
            connected[i].append(j)
            connected[j].append(i)

path = [-1 for _ in range(n)]
q = [start]
while q:
    node = q.pop()
    for next_node in connected[node]:
        if path[next_node] == -1:
            path[next_node] = node
            q.append(next_node)

if path[end] == -1:
    print(-1)
else:
    find_path = []
    search_path = end
    while search_path != start:
        find_path.append(search_path + 1)
        search_path = path[search_path]
    find_path.append(start + 1)

    result = ""
    for item in find_path[::-1]:
        result += str(item) + ""
    print(result)
