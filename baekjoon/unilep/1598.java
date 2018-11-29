package test;

import java.util.Scanner;

public class Test {

	static class Node {
		int x;
		int y;
	}
	
	public static Node f(int a) {
		Node node = new Node();
		node.x = a % 4;
		if(node.x == 0) {
			node.x = 4;
		}
		node.y = a / 4;
		if(a % 4 > 0) {
			node.y++;
		}
		return node;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Node a = f(N);
		Node b = f(M);
		System.out.println(Math.abs(a.x - b.x) + Math.abs(a.y - b.y));
	}
	
}
