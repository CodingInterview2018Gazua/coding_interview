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

		Node ans = sum(A, B); // 617 + 295 = 912
		ps.println(ans);
		
		A = new Node(7);
		A.addNode(1);
		A.addNode(6);

		B = new Node(5);
		B.addNode(9);
		B.addNode(6);
		
		ans = sum(A, B); // 617 + 695 = 1312
		ps.println(ans);
		
		A = new Node(6);
		A.addNode(1);
		A.addNode(7);
		
		B = new Node(2);
		B.addNode(9);
		B.addNode(5);
		
		ans = sum2(A, B); // 617 + 295 = 912
		ps.println(ans);
		
		A = new Node(6);
		A.addNode(1);
		A.addNode(7);
		
		B = new Node(6);
		B.addNode(9);
		B.addNode(5);
		
		ans = sum2(A, B); // 617 + 695 = 1312
		ps.println(ans);
	}
	
	public static int Pow(int a, int b) {
		if(b == 0) return 1;
		else if(b == 1) return a;
		
		if((b & 1) > 0) return a * Pow(a, b-1);
		
		int K = Pow(a, b / 2);
		return K * K;
	}

	public static Node sum(Node A, Node B) {
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
		Node answer = new Node();
		
		while(T > 0) {
			sum = sum * 10 + (T % 10);
			answer.addNode(T % 10);
			T /= 10;
		}
		
		ps.println("sum : " + sum);

		return answer;
	}
	
	public static Node sum2(Node A, Node B) {
		int sum = 0;
		
		while(A != null) {
			int c = A.data + B.data;
			if(c >= 10) sum++;
	
			sum = sum * 10 + (c % 10);
			
			A = A.next;
			B = B.next;
		}
		
		ps.println("sum : " + sum);
		
		int T = sum;
		int len = 0;
		while(T > 0) {
			len++;
			T /= 10;
		}
		
		Node answer = new Node();
		while(len > 0 && sum > 0) {
			T = Pow(10, --len);
			int K = sum / T;
			answer.addNode(K);
			sum -= K * T;
		}
		
		return answer;
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
	
	@Override
	public String toString(){
		Node temp = this.next;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while(temp != null) {
			sb.append(temp.data);
			temp = temp.next;
			if(temp != null) sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
}
