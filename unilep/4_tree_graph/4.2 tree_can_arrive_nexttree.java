
package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Node A = new Node('A');
		Node B = new Node('B');
		Node C = new Node('C');
		Node D = new Node('D');
		Node E = new Node('E');
		
		A.addNode(B);
		A.addNode(C);
		B.addNode(D);
		D.addNode(E);
		
		System.out.println((search(A, E, toInt(A.c)) ? "OK " : "NO"));
		
		
	}
	
	static int toInt(char c) {
		return (1 << (c - 'A'));
	}
	
	static boolean search(Node src, Node dest, int status) {
		boolean b = false;
		for(Node node : src.next) {
			if(node == dest) return true;
			int k = Main.toInt(node.c);
			if((k & status) > 0) continue;
			b |= search(node, dest, status | k);
		}
		return b;
	}
	
}

class Node {
	char c;
	List<Node> next;
	
	Node(char c) {
		this.c = c;
		next = new ArrayList<>();
	}
	
	void addNode(Node node) {
		next.add(node);
	}	
	
}
