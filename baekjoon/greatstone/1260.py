# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
문제: https://www.acmicpc.net/problem/1260
풀이: DFS는 스택을 이용하여 순회 (스택에 정점을 넣을 때는 역순으로 넣어야 작은 것부터 순회할 수 있음)
     BFS는 큐를 이용하여 순회
"""

import queue

n, m, start = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(m)]
graph = {}
for edge in edges:
    if not edge[0] in graph:
        graph[edge[0]] = []
    if not edge[1] in graph:
        graph[edge[1]] = []
    graph[edge[0]].append(edge[1])
    graph[edge[1]].append(edge[0])

for value in graph.values():
    value.sort()


def dfs():
    visited = [False for _ in range(n + 1)]
    stack = [start]
    answer = ""
    while stack:
        v = stack.pop()
        if not visited[v]:
            visited[v] = True
            answer += str(v) + " "
            for dst in reversed(graph[v]):
                stack.append(dst)
    return answer


def bfs():
    visited = [False for _ in range(n + 1)]
    q = queue.Queue()
    q.put(start)
    answer = ""
    while not q.empty():
        v = q.get()
        if not visited[v]:
            visited[v] = True
            answer += str(v) + " "
            for dst in graph[v]:
                q.put(dst)
    return answer


print(dfs())
print(bfs())
