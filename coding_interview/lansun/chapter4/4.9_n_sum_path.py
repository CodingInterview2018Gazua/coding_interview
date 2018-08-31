# /usr/bin/python
# -*- coding: utf-8 -*-
# Python 2.7.10

# 4.9 각 노드에 정수 값이 포함 된 이진 트리가 제공됩니다 (양수 또는 음수 일 수 있음).
# 주어진 값에 합산되는 경로 수를 계산하는 알고리즘을 설계합니다.
# 경로는 루트 또는 리프에서 시작하거나 끝낼 필요가 없지만 아래쪽으로 이동해야합니다 (부모 노드에서 자식 노드로만 이동).


class BinaryNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def count_path_with_sum(node, target_sum):
    if node is None: return 0

    return count_path_with_sum_from_node(node, target_sum, 0) + \
           count_path_with_sum(node.left, target_sum) + \
           count_path_with_sum(node.right, target_sum)


# 이 노드에서 시작하는 이 합계를 가진 경로 수를 반환
def count_path_with_sum_from_node(node, target_sum, current_sum):
    if node is None: return 0

    total_path_count = 0
    if current_sum is target_sum: total_path_count += 1

    total_path_count += count_path_with_sum_from_node(node.left, target_sum, current_sum)
    total_path_count += count_path_with_sum_from_node(node.right, target_sum, current_sum)

    return total_path_count


"""
       10
     /    \
    5     -3
   /  \     \
  3    2    11
 / \    \
3  -2    1

"""
tree = BinaryNode(10)
tree.left = BinaryNode(5)
tree.left.left = BinaryNode(3)
tree.left.right = BinaryNode(2)
tree.left.right.right = BinaryNode(1)
tree.left.left.left = BinaryNode(3)
tree.left.left.right = BinaryNode(-2)

tree.right = BinaryNode(-3)
tree.right.right = BinaryNode(11)

print tree.right.right.data
print count_path_with_sum(tree, 0) # 26
print count_path_with_sum(tree, 8) # 10
print count_path_with_sum(tree, 4) # 10
