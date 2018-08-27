package Chapter3;

public class TopOfHanoi {
	private Stack<Integer> mLeft;
	private Stack<Integer> mMid;
	private Stack<Integer> mRight;

	public TopOfHanoi(int size) {
		mLeft = new Stack<>(size);
		mMid = new Stack<>(size);
		mRight = new Stack<>(size);

		for (int i = size; i > 0; i--) {
			mLeft.push(Integer.valueOf(i));
		}

		System.out.println("Initial State");
		printHanoi();
	}

	public void startMove() {
		hanoi(Position.LEFT, Position.MID, Position.RIGHT);
	}

	void hanoi(Position from, Position by, Position to) {
		if (mLeft.top == -1)
			return;

		if (mLeft.top == 0)
			move(from, to);
		else {
			hanoi(from, to, by);
			move(from, to);
			hanoi(by, from, to);
		}
	}

	private boolean move(Position from, Position to) {
		if (from == to)
			return false;

		Integer fromValue = peekData(from);

		if (fromValue == null)
			return false;

		switch (to) {
		case LEFT:
			if (mLeft.peek() == null) {
				return mLeft.push(popData(from));
			} else {
				if (fromValue.compareTo(mLeft.peek()) == -1) {
					return mLeft.push(popData(from));
				}
			}
			break;
		case MID:
			if (mMid.peek() == null) {
				return mMid.push(popData(from));
			} else {
				if (fromValue.compareTo(mMid.peek()) == -1) {
					return mMid.push(popData(from));
				}
			}

			break;
		case RIGHT:
			if (mRight.peek() == null) {
				return mRight.push(popData(from));
			} else {
				if (fromValue.compareTo(mRight.peek()) == -1) {
					return mRight.push(popData(from));
				}
			}

			break;
		}

		return false;
	}

	private Integer peekData(Position position) {
		Integer data = null;

		switch (position) {
		case LEFT:
			data = mLeft.peek();
			break;
		case MID:
			data = mMid.peek();
			break;
		case RIGHT:
			data = mRight.peek();
			break;
		}

		return data;
	}

	private Integer popData(Position position) {
		Integer data = null;

		switch (position) {
		case LEFT:
			data = mLeft.pop();
			break;
		case MID:
			data = mMid.pop();
			break;
		case RIGHT:
			data = mRight.pop();
			break;
		}

		return data;
	}

	public void printHanoi() {
		System.out.println("LEFT");
		mLeft.printStack();
		System.out.println("MID");
		mMid.printStack();
		System.out.println("RIGHT");
		mRight.printStack();
	}

	enum Position {
		LEFT, MID, RIGHT
	}
}
