package Chapter3;

public class Stack<T> {
	private T[] mStack;
	public int top = -1;

	@SuppressWarnings("unchecked")
	public Stack(int size) {
		mStack = (T[]) new Object[size];
	}

	public boolean push(T data) {
		if (isFull()) {
			System.out.printf("stack is full\n");
			return false;
		}

		top++;
		mStack[top] = data;

		return true;
	}

	public T pop() {
		if (isEmpty()) {
			System.out.printf("stack is empty\n");
			return null;
		}

		T data = mStack[top];
		mStack[top] = null;
		--top;

		return data;
	}

	public T peek() {
		if (isEmpty()) {
			return null;
		}

		return mStack[top];
	}

	public boolean isFull() {
		return top == mStack.length - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void printStack() {
		for (T data : mStack) {
			if (data != null)
				System.out.println(data);
		}
	}
}
