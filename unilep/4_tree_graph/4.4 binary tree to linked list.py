# -'*' coding: utf-8 '*'

import Queue

class Node:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None
		
	def add_left(self, data):
		self.left = Node(data)
	
	def add_right(self, data):
		self.right = Node(data)

class LinkedList:
	
	def __init__(self, data = None):
		self.data = data
		self.next = None

	def add_next(self, data):
		temp_next = self
	
		while temp_next.next is not None:
			temp_next = temp_next.next
	
		temp_next.next = LinkedList(data)
	
	def __repr__(self):
		temp_next = self
		ret = [ ]
		while temp_next.next is not None:
			ret.append(temp_next.data)
			temp_next = temp_next.next

		ret.append(temp_next.data)
		
		return "{}".format(ret)
		
def bfs(root):
	q = Queue.Queue()
	q.put(root)
	
	root_list = [ ]
	
	while not q.empty():
		size = q.qsize()
		
		linked_list = None
		array = [ ]
		
		for i in range(size):
			node = q.get()
			if i is 0: linked_list = LinkedList(node.data)
			else: linked_list.add_next(node.data)
			
			if node.left is not None: q.put(node.left)
			if node.right is not None: q.put(node.right)
				
		root_list.append(linked_list)
		
	return root_list
		
root = Node(1)
root.add_left(3)
root.add_right(5)

root.left.add_left(10)
root.left.add_right(4)

root.right.add_left(2)
root.right.add_right(6)

root.left.left.add_left(1)
root.left.left.add_right(2)
root.left.right.add_left(3)
root.left.right.add_left(4)

root.right.left.add_left(5)
root.right.left.add_right(6)
root.right.right.add_left(7)
root.right.right.add_right(8)

result = bfs(root)
print result