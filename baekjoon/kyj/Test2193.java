import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2193 {

    public static void main(String[] args) throws IOException {
        /**
         * description : 백준 2193번 이친수
         * solution : 1. 점화식을 구하면, 피보나치와 똑같다. fibo(n - 2) + fibo(n - 1)
         *            2. 다만, 다이나믹프로그래밍을 적용해야 하므로 재귀가 아닌, 배열에 해당 값들을 넣어둔다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++){
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        System.out.println(arr[num - 1]);
    }
}