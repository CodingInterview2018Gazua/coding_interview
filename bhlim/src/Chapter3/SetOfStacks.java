package Chapter3;

import java.util.ArrayList;

public class SetOfStacks<T> {
	private ArrayList<Stack<T>> mStacks = new ArrayList<>();
	private int mSize;

	public SetOfStacks(int size) {
		mSize = size;
		mStacks.add(new Stack<>(mSize));
	}

	public void push(T data) {
		if (isFull()) {
			Stack<T> stack = new Stack<>(mSize);
			stack.push(data);
			mStacks.add(stack);
		} else {
			mStacks.get(mStacks.size() - 1).push(data);
		}
	}

	public T pop() {
		if (isEmpty()) {
			System.out.printf("stack is empty\n");
			return null;
		} else {

			return mStacks.get(mStacks.size() - 1).pop();
		}
	}

	private boolean isFull() {
		return mStacks.get(mStacks.size() - 1).isFull();
	}

	public boolean isEmpty() {
		if (mStacks.size() == 1) {
			return mStacks.get(0).isEmpty();
		} else {
			return false;
		}
	}

	public void printStack() {
		for (Stack<T> stack : mStacks) {
			stack.printStack();
		}
	}
}
