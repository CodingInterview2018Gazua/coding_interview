import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 10. 25..
 */
public class Test2579 {
    public static void main(String[] args)throws IOException{
        /**
         * description : 백준 2579번 계단 오르기
         * solution : dp로 접근하여, 마지막 계단 전을 밟은 경우, 마지막 계단 전전을 밟은 경우로 나누어서 접근.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = array[0];
        for(int i = 1; i < 3; i++) {
            if (i == 1) {
                dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            } else {
                dp[i] = Math.max(dp[i - 2] + array[i], array[i - 1] + array[i]);
            }
        }

        for(int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + array[i], dp[i - 3] + array[i - 1] + array[i]);
        }

        System.out.println(dp[n - 1]);
    }
}
