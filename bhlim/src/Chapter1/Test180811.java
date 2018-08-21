package Chapter1;

import java.util.HashMap;
import java.util.Map;

public class Test180811 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		System.out.println(test1("(())))()"));
	}

	public static boolean checkDuplication(String input) {
		char selectedChar;

		for (int i = 0; i < input.length(); i++) {
			selectedChar = input.charAt(i);

			for (int j = i + 1; j <= input.length() - 1; j++) {
				if (selectedChar == input.charAt(j))
					return false;
				else
					continue;
			}
		}

		return true;
	}

	public static String reverseStr(String input) {
		String output = "";

		for (int i = input.length() - 1; i > -1; i--) {
			output += input.charAt(i);
		}

		return output;
	}

	public static boolean contains(String dest, String target) {
		boolean isContains = false;
		int lengthDiff = Math.abs(dest.length() - target.length());

		if (lengthDiff == 0) {
			return dest.equals(target);
		} else {
			String newDest;

			if (dest.length() < target.length()) {
				newDest = target;
				target = dest;
			} else {
				newDest = dest;
			}

			for (int i = 0; i < newDest.length() - lengthDiff; i++) {
				char selectedChar = newDest.charAt(i);

				for (int j = 0; j < target.length(); j++) {
					if (selectedChar == target.charAt(j))
						isContains = true;
					else
						isContains = false;
				}

				if (isContains)
					break;
			}
		}

		return isContains;
	}

	public static char[] replaceSpace(String input) {
		char[] charArr = input.toCharArray();
		String output = "";

		for (char selected : charArr) {
			if (selected == ' ')
				output += "%20";
			else
				output += selected;
		}

		return output.toCharArray();
	}

	public static String zipStr(String input) {
		Map<String, Integer> zipMap = new HashMap<>();
		String output = "";

		for (int i = 0; i < input.length(); i++) {
			String selectedStr = input.charAt(i) + "";

			if (zipMap.containsKey(selectedStr)) {
				int count = zipMap.get(selectedStr);
				zipMap.put(selectedStr, ++count);
			} else {
				zipMap.put(selectedStr, 1);
			}
		}

		for (String key : zipMap.keySet()) {
			output += key + zipMap.get(key);
		}

		if (input.length() <= output.length())
			return input;
		else
			return output;
	}

	public static int[][] rotateTo90Degree(int[][] input) {
		final int size = input.length;
		int[][] output = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				output[size - 1 - j][i] = input[i][j];
			}
		}

		return output;
	}

	public static int test1(String input) {
		int open = 0;
		int close = 0;

		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				open++;
			} else if (input.charAt(i) == ')') {
				close++;
			}

			if (open == close) {
				leftSum += open;
				open = 0;
				close = 0;
			}

			if (i == input.length() - 1)
				rightSum = close;
		}

		return leftSum + rightSum;
	}
}
