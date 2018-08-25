# -'*' coding: utf-8 '*'
import Queue


class Node:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None
		
	def add_left(self, node):
		self.left = node
	
	def add_right(self, node):
		self.right = node


def check_value(node, left_nodes, right_nodes):
	for val in left_nodes:
		if not node.data > val: return False
	for val in right_nodes:
		if not node.data < val: return False
	return True


def is_binary_search_tree(root, left_nodes = [ ], right_nodes = [ ]):
	result = True
	if root.left is not None:
		right_nodes.append(root.data)
		if not check_value(root.left, left_nodes, right_nodes): return False
		result = is_binary_search_tree(root.left, left_nodes, right_nodes)
		right_nodes.pop()
	
	if result and root.right is not None:
		left_nodes.append(root.data)
		if not check_value(root.right, left_nodes, right_nodes): return False
		result = is_binary_search_tree(root.right, left_nodes, right_nodes)
		left_nodes.pop()
	
	return result


root = Node(4)

left = Node(2)
right = Node(6)
root.add_left(left)
root.add_right(right)

left_left = Node(1)
left_right = Node(3)
left.add_left(left_left)
left.add_right(left_right)

right_left = Node(5)
right_right = Node(7)
right.add_left(right_left)
right.add_right(right_right)


'''
				4
		2				6
	1		3		5		7
'''

result = is_binary_search_tree(root)
print result
