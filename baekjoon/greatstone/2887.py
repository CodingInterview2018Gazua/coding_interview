# 문제: https://www.acmicpc.net/problem/2887
# 풀이: Edge 만드는 방법과 크루스칼을 적용하는 것이 핵심

import sys

def makeEdges(vertices):
    sorted_vertices = sorted(vertices)
    edges = []
    for i in range(1, len(sorted_vertices)):
        cost = abs(sorted_vertices[i - 1][0] - sorted_vertices[i][0])
        edges.append((cost, sorted_vertices[i - 1][1], sorted_vertices[i][1]))
    return edges

parent = dict()
rank = dict()

def make_set(vertice):
    parent[vertice] = vertice
    rank[vertice] = 0

def find(vertice):
    if parent[vertice] != vertice:
        parent[vertice] = find(parent[vertice])
    return parent[vertice]

def union(vertice1, vertice2):
    root1 = find(vertice1)
    root2 = find(vertice2)
    if root1 != root2:
        if rank[root1] > rank[root2]:
            parent[root2] = root1
        else:
	        parent[root1] = root2
        if rank[root1] == rank[root2]: rank[root2] += 1
        
def kruskal(edges):
    sorted_edges = sorted(edges)
    sum_cost = 0
    for edge in sorted_edges:
        cost, v1, v2 = edge
        if find(v1) != find(v2):
            union(v1, v2)
            sum_cost += cost
    return sum_cost

n = int(sys.stdin.readline())
planet_x = []
planet_y = []
planet_z = []
for i in range(n):
    x, y, z = map(int, sys.stdin.readline().split())
    planet_x.append((x, i))
    planet_y.append((y, i))
    planet_z.append((z, i))

edges = makeEdges(planet_x)
edges.extend(makeEdges(planet_y))
edges.extend(makeEdges(planet_z))

for i in range(n):
    make_set(i)
print(kruskal(edges))
