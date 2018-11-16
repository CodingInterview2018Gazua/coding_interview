import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 11. 17..
 */
public class Test1074 {
    public static int result = 0;
    public static int r,c = 0;
    public static void main(String[] args) throws IOException {
        /**
         * solution : 백준 1074번 Z
         * description : 1. 4개로 분할되는 사각형을 재귀로 판단한다.
         *               2. 다만 주어진 (r, c)가 사각형에 속하지 않는다면
         *               그 사각형은 재귀에 들어갈 필요가 없이 len*len을 result에 더한 후, return 한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        int N = Integer.parseInt(str[0]);
        r = Integer.parseInt(str[1]);
        c = Integer.parseInt(str[2]);
        recursion(0, 0, (int)Math.pow(2, N));
    }

    public static void recursion(int x, int y, int len){
        if(x == r && y == c){
            System.out.println(result);
            return;
        }

        if(len == 1){
            result++;
            return;
        }

        if(!(x <= r && r < x + len && y <= c && c < y + len)){
            result += len * len;
            return;
        }

        recursion(x, y,len / 2);

        recursion(x,y + len / 2,len / 2);

        recursion(x + len / 2, y,len / 2);

        recursion(x + len / 2,y + len / 2,len / 2);
    }
}