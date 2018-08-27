package algorithm;

import java.io.PrintStream;

public class Main {

	public static PrintStream ps = System.out;

	public static void main(String[] args) {
		Node A = new Node('A');
		A.addNode('B');
		A.addNode('C');
		A.addNode('D');
		A.addNode('E');
		A.addNode('C');
		
		ps.println(A.searchCycle(0, 'A'));
		
	}

}

class Node {
	char data;
	Node next;

	Node() { }

	Node(char data) {
		this.data = data;
	}

	void addNode(final char data) {
		Node newNode = new Node(data);
		Node temp = this;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
	
	char searchCycle(int status, final int diff) {
		if((status & (1 << (data - diff))) > 0) return data;
		return this.next.searchCycle(status | (1 << (data - diff)), diff);
	}
	
}
