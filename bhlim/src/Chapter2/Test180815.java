package Chapter2;

import LinkedList.LinkedList;
import LinkedList.Node;

public class Test180815 {
	public static void main(String[] args) {

		// 2.5
		LinkedList<Integer> dest = new LinkedList<>();
		LinkedList<Integer> target = new LinkedList<>();

		dest.addNode(7);
		dest.addNode(1);
		dest.addNode(6);

		target.addNode(5);
		target.addNode(9);
		target.addNode(2);

		addList(dest, target).printNodes();

		// 2.6
		LinkedList<String> circularList = new LinkedList<>();

		circularList.addNode("A");
		circularList.addNode("B");
		circularList.addNode("C");
		circularList.addNode("D");
		circularList.addNode("E");
		circularList.makeCircularNode();

		circularList.printNodes();

		System.out.println(getCircularNodeData(circularList));

		// 2.7
		LinkedList<String> palindromeList = new LinkedList<>();

		palindromeList.addNode("t");
		palindromeList.addNode("o");
		palindromeList.addNode("m");
		palindromeList.addNode("o");
		palindromeList.addNode("t");

		System.out.println(isPalindromeList(palindromeList));
	}

	public static LinkedList<Integer> addList(LinkedList<Integer> dest, LinkedList<Integer> target) {
		LinkedList<Integer> result = new LinkedList<Integer>();

		String destStr = "";
		String targetStr = "";

		for (int i = dest.size - 1; i > -1; i--) {
			destStr += dest.getNode(i).data.toString();
		}

		for (int i = target.size - 1; i > -1; i--) {
			targetStr += target.getNode(i).data.toString();
		}

		String sumString = String.valueOf(Integer.parseInt(destStr) + Integer.parseInt(targetStr));

		for (int i = sumString.length() - 1; i > -1; i--) {
			int value = Character.getNumericValue(sumString.charAt(i));
			result.addNode(value);
		}

		return result;
	}

	public static String getCircularNodeData(LinkedList<String> input) {
		return input.tail.data;
	}

	public static <T> boolean isPalindromeList(LinkedList<T> input) {
		int half = (int) (input.size / 2);

		for (int i = 0; i <= half; i++) {
			boolean equals = input.getNode(i).data.equals(input.getNode(input.size - 1 - i).data);

			if (!equals)
				break;

			if (i == half)
				return true;
		}

		return false;
	}
}
