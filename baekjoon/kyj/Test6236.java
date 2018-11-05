import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 11. 5..
 */
public class Test6236 {

    public static int []m = new int[100003];
    public static int N, M;
    public static void main(String[] arg) throws IOException{
        /**
         * description : 백준 6236번 용돈관리
         * solution : 이진 탐색으로 접근
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);

        int start = 1;
        int num = 1000000000;
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, m[i]);
        }

        while (start < num) {
            int mid = (start + num) / 2;
            if (calc(mid) > M) {
                start = mid + 1;
            }else {
                num = mid;
            }
        }

        System.out.println(start);
    }

    public static int calc(int limit) {
        int ans = 1;
        int now = 0;
        for (int i = 0; i < N; i++) {
            if (now + m[i] > limit) {
                ans++;
                now = m[i];
            }else{
                now += m[i];
            }
        }
        return ans;
    }
}
