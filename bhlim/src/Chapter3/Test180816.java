package Chapter3;

public class Test180816 {
	public static void main(String[] args) {
		Stack stack = new Stack(5);
	
		stack.push(0, 1);
		stack.push(0, 1);
		stack.push(0, 1);
		stack.push(0, 1);
		stack.push(0, 1);
		stack.push(0, 1);
		
		stack.push(1, 1);
		stack.push(1, 1);
		stack.push(1, 1);
		stack.push(1, 1);
		
		stack.push(2, 1);
		stack.push(2, 1);
		stack.push(2, 1);
		stack.push(2, 1);
		stack.push(2, 1);
		stack.push(2, 1);
		
		
//		System.out.printf("pop = %d\n", stack.pop(0));
//		System.out.printf("pop = %d\n", stack.pop(0));
//		System.out.printf("pop = %d\n", stack.pop(0));
//		System.out.printf("pop = %d\n", stack.pop(0));
//		System.out.printf("pop = %d\n", stack.pop(0));
//		System.out.printf("pop = %d\n", stack.pop(0));
		
		stack.printStack();
	}
}
