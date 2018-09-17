# !/usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7


"""
https://www.acmicpc.net/problem/2263

preorder
in order : left root right
pre order : root left right
post order : left right root
"""
# import sys
# sys.setrecursionlimit(10000000)


# def preorder2(in_left, in_right, post_left, post_right, idx):
#     if post_left <= post_right:
#
#         left_num = idx - in_left
#         right_num = in_right - idx
#
#         preorder2(in_left, in_left+left_num-1, post_left, post_left+left_num-1, idx)
#         preorder2(in_right-right_num, in_right, post_right-right_num, post_right-1, idx)

# if not preorder:
#     return []
# else:
#     root = preorder[0]
#     left = list(itertools.takewhile(lambda x: x < root, preorder[1:]))
#     right = preorder[len(left) + 1:]
#     return postorder(left) + postorder(right) + [root]


def preorder(inorder, root, root_idx):
    if root is None: return

    left = inorder[:root_idx]
    right = inorder[root_idx+1:]

    print left

    preordered = [root] + left + right
    # return [root] + preorder(left, root, root_idx) + preorder(right, root, root_idx)
    # return ' '.join(str(e) for e in preordered)


n = 3 #raw_input()
inorder = [1, 2, 3] #map(int, raw_input().split())
postorder = [1, 3, 2] #map(int, raw_input().split())

root = postorder[-1]
root_idx = inorder.index(root)

print preorder(inorder, root, root_idx)

# root = postorder[n-1]
# idx = inorder.index(root)
# print preorder2(0, n-1, 0, n-1, idx)