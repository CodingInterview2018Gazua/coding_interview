import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yong on 2018. 11. 2..
 */
public class Test1149 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1149번 RGB거리
         * solution : 1. dp[1] 배열에 arr[1](첫 번째 집 부터) 최소 비용이 들어간다고 생각하는데,
         *            2. dp는 이전 배열의 최소 비용을 계속 더해 나간다. (다만, 이웃과 색이 겹치지 않는 조건에 따라)
         *            3. 배열의 마지막 행, 3개의 값 중 최소값이 정답
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N + 1][3];
        int dp[][] = new int[N + 1][3];
        for(int i = 1; i <= N; i++){
            String[] strs = br.readLine().trim().split(" ");
            arr[i] = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = 0;
        for(int i = 1; i <= N; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }

        int miniumCost = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);

        System.out.println(miniumCost);
        /*
        for(int i = 0; i <= N; i++){
            for(int j = 0; j < 3; j++) {

                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        */
    }
}
