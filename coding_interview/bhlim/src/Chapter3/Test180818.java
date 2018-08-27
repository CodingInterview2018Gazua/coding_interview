package Chapter3;

public class Test180818 {
	public static void main(String[] args) {
		TopOfHanoi hanoi = new TopOfHanoi(3);

		hanoi.startMove();

		System.out.println("Result State");
		hanoi.printHanoi();
	}
}
