package Chapter3;

public class Stack<T> {
	private T[] mStack;
	private int mTop = -1;
	
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		mStack = (T[]) new Object[size];
	}
	
	public boolean push(T data) {
		if(isFull()) {
			System.out.printf("stack is full\n");
			return false;
		}
			
		mTop++;
		mStack[mTop] = data;
		
		return true;
	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.printf("stack is empty\n");
			return null;
		}
			
		T data = mStack[mTop];
		mStack[mTop] = null;
		--mTop;
	
		return data;
	}
	
	public boolean isFull() {
		return mTop == mStack.length -1;
	}
	
	public boolean isEmpty() {
		return mTop == -1;
	}
	
	public void printStack() {
		for (T data : mStack) {
			if(data != null)
				System.out.println(data);
		}
	}
}
