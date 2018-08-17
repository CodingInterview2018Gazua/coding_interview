package Chapter3;

public class Stack3 {
	private int[][] mStack;
	private int[] mTops = {-1,-1,-1};
	
	public Stack3(int size) {
		mStack = new int[3][size];
	}
	
	public boolean push(int position, int data) {
		int idx = mTops[position];
		
		if(isFull(position)) {
			System.out.printf("position %d stack is full\n", position);
			return false;
		}
			
		idx++;
		mStack[position][idx] = data;
		mTops[position] = idx;
		
		return true;
	}
	
	public int pop(int position) {
		int idx = mTops[position];
		
		if(isEmpty(position)) {
			System.out.printf("position %d stack is empty\n", position);
			return -1;
		}
			
		int data = mStack[position][idx];
		mStack[position][idx] = 0;
		mTops[position] = --idx;
		
		return data;
	}
	
	public boolean isFull(int position) {
		return mTops[position] == mStack[position].length -1;
	}
	
	public boolean isEmpty(int position) {
		return mTops[position] == -1;
	}
	
	public void printStack() {
		for(int[] row : mStack) {
			for (int data : row) {
				System.out.print(data);
			}
			System.out.println("\n");
		}
	}
}
