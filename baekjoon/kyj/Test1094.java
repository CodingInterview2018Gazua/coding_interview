import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 10. 31..
 */
public class Test1094 {
    public static void main(String[] args) throws IOException{
        /**
         * description: 백준 1094번 막대
         * solution: 1. X 가 64인 경우 예외처리
         *           2. 처음의 경우, 절반중 하나의 길이가 크면 N을 2로 나누어 준다
         *           3. 그 후로는, N을 2로 나누고 총합계에서 더한 값이 X 보다 작은경우만
         *           4. sum에 더해주고 cnt를 증가시켜 준다.
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
