# /usr/bin/python
# -*- coding: utf-8 -*-

# 4.2 주어진 유향 그래프(direct graph) 에서 특정한 두 노드간에 경로(route)가 존재하는지를 판별하는 알고리즘을 구현하라
# bfs : breadth-first-search 너비우선탐색
# 두 노드 가운데 한 노드를 선택하여 탐색 도중에 다른 노드가 발견되는지 검사하면 된다
from collections import defaultdict


class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)

    def BFS(self, start):
        visited = [False] * (len(self.graph))
        queue = []

        queue.append(start)
        visited[start] = True

        while queue:
            s = queue.pop(0)
            for i in self.graph[s]:
                if not visited[i]:
                    queue.append(i)
                    visited[i] = True
                else:
                    return True

        return False


graph = Graph()

## ===> First example
graph.add_edge(0, 1)
graph.add_edge(0, 2)
graph.add_edge(1, 2)
graph.add_edge(2, 2)
graph.add_edge(2, 3)
graph.add_edge(3, 3)

print graph.graph
# defaultdict(<type 'list'>, {0: [1, 2], 1: [2], 2: [2, 3], 3: [3]})

print graph.BFS(1)
# True

## ===> Second example
graph.add_edge(0, 1)
graph.add_edge(1, 2)
graph.add_edge(2, 3)
graph.add_edge(3, 4)
graph.add_edge(4, 4)

print graph.graph
# defaultdict(<type 'list'>, {0: [1, 2, 1], 1: [2, 2], 2: [2, 3, 3], 3: [3, 4], 4: [4]})
print graph.BFS(2)
# True
