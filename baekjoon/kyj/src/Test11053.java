import java.util.Scanner;

/**
 * Created by yong on 2018. 9. 18..
 */
public class Test11053 {
    public static void main(String[] args) {
        /**
         * description : 백준 11053번 가장 긴 증가하는 부분 수열(DP 연습 문제)
         * solution : for 문을 2번 돌리면서 i가 가르키는 값이 더 클 경우 dp 배열에 +1씩을 하여
         *            결론적으로 dp 배열의 가장 큰 값을 반환.
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        int[] dp = new int[1001];
        int[] a = new int[1001];

        for(int i = 0; i < n; i++)
            a[i] = in.nextInt();

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++)
                if(a[i] > a[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
        in.close();
    }
}
