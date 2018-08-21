package Chapter3;

public class Test180819 {
	public static void main(String[] args) {
		SortedStack<Integer> dd = new SortedStack<>(5);

		dd.push(4);
		dd.push(6);
		dd.push(7);
		dd.push(3);
		dd.push(2);

		dd.sortForAsc();
	}
}
