package test;

import java.util.Scanner;

public class Test {
	
	static int[][][] D = new int[21][21][21];
	static int k;
	
	static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if(a > 20 || b > 20 || c > 20) {
			return k;
		}
		if(D[a][b][c] != -1) {
			return D[a][b][c];
		}
		if(a < b && b < c) {
			return D[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
		}
		return D[a][b][c] = w(a-1, b, c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<21; i++) for(int j=0; j<21; j++) for(int k=0; k<21; k++) D[i][j][k] = -1;
		k = w(20, 20, 20);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
		}
	}
	
}
