package algorithm;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Main {

	static PrintStream ps = System.out;

	public static void main(String[] args) {

		SetOfStacks<Integer> stack = new SetOfStacks<>();
		for(int i=1; i<=10; i++) {
			stack.push(i);
		}
		
		stack.popAt(0);
		
		for(int i=1; i<10; i++){
			ps.println(stack.pop());
		}
		
	}
}

class SetOfStacks<T> {

	static private final int MAX_SIZE = 5;

	private List<Stack<T>> stacks;
	private Stack<T> currentStack;

	public	SetOfStacks() {
		stacks = new ArrayList<Stack<T>>();
	}

	void push(T data) {
		if(currentStack == null || currentStack.size() == MAX_SIZE) {
			currentStack = new Stack<T>();
			stacks.add(currentStack);
		}
		currentStack.push(data);
	}

	T pop() {
		if(currentStack == null) throw new EmptyStackException();

		if(currentStack.isEmpty()) {
			stacks.remove(stacks.size() - 1);
			if(stacks.isEmpty()) throw new EmptyStackException();
			currentStack = stacks.get(stacks.size() - 1);
		}
		return currentStack.pop();
	}
	
	T popAt(int index) {
		Stack<T> tempStack = stacks.get(index);
		if(tempStack == null) {
			throw new EmptyStackException();
		}
		return tempStack.pop();
	}

}
