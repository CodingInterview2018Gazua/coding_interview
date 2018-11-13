package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6131 {
    public static void main(String[] args) throws IOException {
        /**
         * description : 백준 6131번 완전 제곱수
         * solution : 1. 수식을 구한다. 수식 : A^2 = B^2 + N
         *            2. for 문에 1 부터 500 까지의 숫자를 넣어주면서 가능한 짝을 카운트한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 1; i < 500; i++){

            for(int j = 1; j < 500; j++) {
                if(i < j) break;

                if(Math.pow(i, 2) == Math.pow(j, 2) + N){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
