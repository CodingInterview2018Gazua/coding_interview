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
		tempNext = self.next
		while tempNext is not None:
			tempNext = tempNext.next
			
		tempNext = LinkedList(data)
	
	def __str__(self):
		return self.data
		
def bfs(root):
	q = Queue.Queue()
	q.put(root)
	
	linkedList = [ ]
	
	while not q.empty():
		size = q.qsize()
		linkedlist = LinkedList('dummy')
		
		array = [ ]
		for i in range(size):
			node = q.get()
			array.append(node.data)
			linkedlist.addNext(node)
			if node.left is not None:
				q.put(node.left)
			if node.right is not None:
				q.put(node.right)
				
		print array # actually linkedlist result #
		linkedList.append(linkedlist)
		
	return linkedList
		
		
root = Node(1)
root.addLeft(3)
root.addRight(5)

root.left.addLeft(10)
root.left.addRight(4)

root.right.addLeft(2)
root.right.addRight(6)

result = bfs(root)
print str(result)

