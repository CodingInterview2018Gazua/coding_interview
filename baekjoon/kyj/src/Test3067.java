import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yongjin on 2018-09-19.
 */
public class Test3067 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 3067번 Coin, 동전의 종류가 주어질 때 주어진 금액을 만드는 모든 방법을 세는 프로그램. (DP 연습)
         * solution : 3067.cpp 참고
         */
        int T, N, M;
        int[] dp;
        int[] coin;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            dp = new int[10001];
            coin = new int[20];

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++)
                coin[i] = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(br.readLine());
            dp[0] = 1;
            for(int i = 0; i < N; i++){
                for(int j = coin[i]; j <= M; j++){
                    dp[j] += dp[j - coin[i]];
                }
            }
            System.out.println(dp[M]);
        }
    }
}
