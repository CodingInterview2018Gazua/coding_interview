package Chapter3;

public class SortedStack<T extends Comparable<T>> {
	private Stack<T> mStack;
	private Stack<T> mTempStack;
	private int mSize;
	
	public SortedStack(int size) {
		mStack = new Stack<>(size);
		mTempStack = new Stack<>(size);
		mSize = size;
	}
	
	public boolean push(T data) {
		return mStack.push(data);
	}
	
	public void sortForAsc() {
		T min = null;
		T sortedMin = null;
		int sortedCount = 0;
		
		while(sortedCount <= mSize) {
			while(mStack.top != -1 + sortedCount) {
				T data = mStack.pop();
				
				if(min == null) {
					min = data;
				} else {
					if(min.compareTo(data) == 1 && sortedMin != null && sortedMin.compareTo(data) == 1 ) {
						min = data;
					}
				}	
				
				mTempStack.push(data);
			}
			
			sortedCount++;
			mStack.push(min);
			sortedMin = min;
			
			for(int i = 0; i < mSize; i++) {
				T data = mTempStack.pop();
				
				if(!min.equals(data))
					mStack.push(data);
			}
		}
		
		mStack.printStack();
		
	}
}
