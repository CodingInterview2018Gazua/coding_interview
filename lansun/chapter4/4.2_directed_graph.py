# /usr/bin/python
# -*- coding: utf-8 -*-

# 4.2 주어진 유향 그래프(direct graph) 에서 특정한 두 노드간에 경로(route)가 존재하는지를 판별하는 알고리즘을 구현하라
# bfs : breadth-first-search 너비우선탐색


def exist_bfs_paths(graph, start, goal):
    queue = [(start, [start])]
    result = []

    while queue:
        n, path = queue.pop(0)
        if n == goal:
            result.append(path)
        else:
            for m in graph[n] - set(path):
                queue.append((m, path + [m]))
    return True if len(result) > 0 else False

graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}

print exist_bfs_paths(graph, 'A', 'F')
