package Chapter1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test180813 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {
				{1,2,3,4}, 
				{5,6,0,8}, 
				{9,0,11,12},
				{13,14,15,16}
				};
		
		System.out.println(findZeroAndSetToZeroAll(test));
		
		//System.out.println(isContainsReverseStr("qwerty", "ytrewq"));
	}
	
	public static int[][] findZeroAndSetToZeroAll(int[][] input) {
		Set<Integer> row = new HashSet<>();
		Set<Integer> column = new HashSet<>();
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input.length; j++) {
				if(input[i][j] == 0) {
					row.add(i);
					column.add(j);
				}
			}
		}
		
		for(Integer rowItem : row) {
			for(int i = 0; i < input[rowItem].length; i++) {
				input[rowItem][i] = 0;
			}
		}
		
		for(int i = 0; i < input.length; i++) {
			for(Integer columnItem : column) {
				input[i][columnItem] = 0;
			}
		}
		
		return input;
	}
	
	public static boolean isContainsReverseStr(String dest, String target) {
		if(dest.length() != target.length())
			return false;
		
		String reverseTarget = "";
		
		for(int i = target.length() -1; i > -1; i--) {
			reverseTarget += target.charAt(i);
		}
		
		return dest.contains(reverseTarget);
	}
	
}
