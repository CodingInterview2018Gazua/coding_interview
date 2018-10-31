import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 10. 31..
 */
public class Test1094 {
    public static void main(String[] args) throws IOException{
        /**
         * description:
         * solution:
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int N = 64;
        int cnt = 0;
        int sum = 0;
        int i = 0;
        while (N > 1) {

            if(X == 64){
                cnt++;
                break;
            }

            if(i == 0) {

                if (N / 2 > X) {
                    N = N / 2;
                }

            }else{
                N = N / 2;
                if(sum + N <= X){
                    sum += N ;
                    cnt++;
                }
            }
            i++;
        }

        System.out.println(cnt);
    }
}
