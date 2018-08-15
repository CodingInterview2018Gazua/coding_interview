package algorithm;

import java.io.PrintStream;

public class Main {

	public static PrintStream ps = System.out;

	public static void main(String[] args) {
		Node A = new Node(7);
		A.addNode(1);
		A.addNode(6);

		Node B = new Node(5);
		B.addNode(9);
		B.addNode(2);

		ps.println(sum(A, B)); // 617 + 295 = 912

		A = new Node(7);
		A.addNode(1);
		A.addNode(6);

		B = new Node(5);
		B.addNode(9);
		B.addNode(6);
		
		ps.println(sum(A, B)); // 617 + 695 = 1312
	}

	public static int sum(Node A, Node B) {
		int sum = 0;
		boolean carry = false;
		while(A != null) {
			int c = A.data + B.data;
			if(carry) {
				carry = false;
				c++;
			}
			if(c >= 10) carry = true;

			sum = sum * 10 + (c % 10);
			A = A.next;
			B = B.next;
		}

		if(carry) sum = sum * 10 + 1;

		int T = sum;
		sum = 0;
		while(T > 0) {
			sum = sum * 10 + (T % 10);
			T /= 10;
		}

		return sum;
	}

}

class Node {
	int data;
	Node next;

	Node() { }

	Node(int data) {
		this.data = data;
	}

	void addNode(int data) {
		Node newNode = new Node(data);
		Node temp = this;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}
}
