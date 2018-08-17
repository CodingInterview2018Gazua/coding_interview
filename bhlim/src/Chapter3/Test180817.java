package Chapter3;

public class Test180817 {
	public static void main(String[] args) {
		SetOfStacks<Integer> stack = new SetOfStacks<>(3);
	
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		
		stack.pop();
		stack.pop();
		stack.pop();
		

		stack.printStack();
	}
}
