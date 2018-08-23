# -'*' coding: utf-8 '*'

import Queue

class Node:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None
		
	def addLeft(self, data):
		self.left = Node(data)
	
	def addRight(self, data):
		self.right = Node(data)

class LinkedList:
	
	def __init__(self, data):
		self.data = data
		self.next = None
	
	def addNext(self, data):
		tempNext = self
		while tempNext.next is not None:
			tempNext = tempNext.next
			
		tempNext.next = LinkedList(data)
		
	def setNext(self, node):
		self.next = node
	
	def __repr__(self):
		tempNext = self
		ret = [ ]
		while tempNext.next is not None:
			ret.append(tempNext.data)
			tempNext = tempNext.next
		ret.append(tempNext.data)
		return repr(ret)
		
def bfs(root):
	q = Queue.Queue()
	q.put(root)
	
	root_list = [ ]
	
	while not q.empty():
		size = q.qsize()
		linkedlist = LinkedList('')
		
		array = [ ]
		for i in range(size):
			node = q.get()
			linkedlist.addNext(node.data)
			if node.left is not None:
				q.put(node.left)
			if node.right is not None:
				q.put(node.right)
				
		root_list.append(linkedlist)
		
	return root_list
		
		
root = Node(1)
root.addLeft(3)
root.addRight(5)

root.left.addLeft(10)
root.left.addRight(4)

root.right.addLeft(2)
root.right.addRight(6)

result = bfs(root)
print repr(result)

