package LinkedList;

public class Node<T> implements Cloneable {
	public T data;
	public Node<T> next;

	public Node(T input) {
		this.data = input;
		this.next = null;
	}

	public Node<T> clone() {
		Node<T> newNode = new Node<>(this.data);

		if (this.next != null)
			newNode.next = this.next.clone();

		return newNode;
	}
}
