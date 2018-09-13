# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

"""
https://www.acmicpc.net/problem/5639
"""

# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7

"""
https://www.acmicpc.net/problem/5639

postorder (후위순회)
1. 왼쪽 서브트리의 모든 노드를 방문한다
2. 오른쪽 서브트리의 모든 노드를 방문한다
3. 루트 노드를 방문한다

"""
import itertools


def postorder(preorder):
    if not preorder:
        return []
    else:
        root = preorder[0]
        left = list(itertools.takewhile(lambda x: x < root, preorder[1:]))
        right = preorder[len(left) + 1:]
        return postorder(left) + postorder(right) + [root]


nodes = [50, 30, 24, 5, 28, 45, 98, 52, 60]
print postorder(nodes)

