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

    def BFS(self, start, end):
        visited = [False] * (len(self.graph))
        queue = []

        queue.append(start)
        visited[start] = True

        while queue:
            s = queue.pop(0)
            for i in self.graph[s]:
                if i == end: return True
                if not visited[i]:
                    visited[i] = True
                    queue.append(i)

        return False


## ===> First example
graph = Graph()
graph.add_edge(0, 1)
graph.add_edge(0, 2)
graph.add_edge(1, 2)
graph.add_edge(2, 2)
graph.add_edge(2, 3)
graph.add_edge(3, 3)

print graph.graph
# defaultdict(<type 'list'>, {0: [1, 2], 1: [2], 2: [2, 3], 3: [3]})

print graph.BFS(1, 1)
# False

## ===> Second example
graph = Graph()
graph.add_edge(0, 2)
graph.add_edge(1, 2)
graph.add_edge(2, 3)
graph.add_edge(3, 4)
graph.add_edge(4, 5)
graph.add_edge(5, 1)

print graph.graph
# defaultdict(<type 'list'>, {0: [2], 1: [2], 2: [3], 3: [4], 4: [5], 5: [1]})
print graph.BFS(1, 1)
# True
