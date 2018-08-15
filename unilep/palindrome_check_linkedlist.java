package algorithm;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static PrintStream ps = System.out;

	public static void main(String[] args) {
		inputJustCharArray();
		inputHashVersion();
	}
	
	static void inputJustCharArray() {
		
		ps.println("charArray Version");
		
		Node A = new Node('A');
		A.addNode('B');
		A.addNode('C');
		A.addNode('B');
		A.addNode('A');
		isPalindromeByCharArray(A);

		A = new Node('A');
		A.addNode('B');
		A.addNode('B');
		A.addNode('A');
		isPalindromeByCharArray(A);
		
		A.addNode('A');
		isPalindromeByCharArray(A);
		
		A = new Node('A');
		isPalindromeByCharArray(A);
		
		A.addNode('A');
		isPalindromeByCharArray(A);
		
		A.addNode('A');
		isPalindromeByCharArray(A);
		
		A.addNode('Z');
		isPalindromeByCharArray(A);
		
		A = new Node('A');
		A.addNode('Z');
		A.addNode('Z');
		A.addNode('A');
		isPalindromeByCharArray(A);
		
		A = new Node('A');
		A.addNode('Z');
		A.addNode('Z');
		A.addNode('Z');
		A.addNode('A');
		isPalindromeByCharArray(A);
	}
	
	static void inputHashVersion() {
		
		ps.println("Hash Version");
		
		Node A = new Node('A');
		A.addNode('B');
		A.addNode('C');
		A.addNode('B');
		A.addNode('A');
		isPalindromeByHash(A);

		A = new Node('A');
		A.addNode('B');
		A.addNode('B');
		A.addNode('A');
		isPalindromeByHash(A);
		
		A.addNode('A');
		isPalindromeByHash(A);
		
		A = new Node('A');
		isPalindromeByHash(A);
		
		A.addNode('A');
		isPalindromeByHash(A);
		
		A.addNode('A');
		isPalindromeByHash(A);
		
		A.addNode('Z');
		isPalindromeByHash(A);
		
		A = new Node('A');
		A.addNode('Z');
		A.addNode('Z');
		A.addNode('A');
		isPalindromeByHash(A);
		
		A = new Node('A');
		A.addNode('Z');
		A.addNode('Z');
		A.addNode('Z');
		A.addNode('A');
		isPalindromeByHash(A);
		
	}

	static List<char[]> divide(final char[] charArray) {
		final int half = charArray.length / 2;
		char[] left = new char[half];
		char[] right = new char[half];
		
		for(int i=0; i<half; i++) {
			left[i] = charArray[i];
			right[i] = charArray[charArray.length - 1 - i];
		}
		
		List<char[]> list = new ArrayList<>();
		list.add(left);
		list.add(right);
		
		return list;
	}
	
	static void isPalindromeByCharArray(Node node) {
		char[] charArray = node.getCharArrays(new ArrayList<Character>());
		ps.print(charArray);
		
		final List<char[]> dividedCharArray = divide(charArray);
		char[] left = dividedCharArray.get(0);
		char[] right = dividedCharArray.get(1);
		
		boolean isPalindrome = true;
		final int len = left.length;
		for(int i=0; i<len && isPalindrome; i++) {
			if(left[i] != right[i]) isPalindrome = false;
		}
		
		ps.println(" is " + (isPalindrome ? "Palindrome" : "Not Palindrome"));
	}
	
	static void isPalindromeByHash(Node node) {
		
		char[] charArray = node.getCharArrays(new ArrayList<Character>());
		ps.print(charArray);
		
		final List<char[]> dividedCharArray = divide(charArray);
		char[] left = dividedCharArray.get(0);
		char[] right = dividedCharArray.get(1);
		
		boolean isPalindrome = Hash.hash(left) == Hash.hash(right);
		ps.println(" is " + (isPalindrome ? "Palindrome" : "Not Palindrome"));
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

	char[] getCharArrays(List<Character> list) {
		list.add(this.data);
		if(this.next == null) {
			int size = list.size();
			char[] charArray = new char[size];
			for(int i=0; i<size; i++) {
				charArray[i] = list.get(i); 
			}
			return charArray;
		}
		return this.next.getCharArrays(list);
	}

	boolean isPalindromeByHash() {
		return true;
	}

}

class Hash {
	private static final int key = 26; 

	public static int hash(char[] c) {
		final int len = c.length;
		int hashValue = 0;
		for(int i=0; i<len; i++) {
			hashValue = hashValue * key + (1 << (c[i] - 'A'));
		}
		return hashValue;
	}
}
