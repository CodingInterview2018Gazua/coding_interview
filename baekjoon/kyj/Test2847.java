import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 10. 23..
 */
public class Test2847 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 2847번 게임을 만든 동준이
         * solution : 배열의 마지막부터 하나씩 앞의 Index로 가면서 배열의 뒷부분 보다 앞부분이 크면
         *            arr[i] - arr[i - 1]) - 1 으로 빼줘야 하는 수를 구해준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 0;
        for(int i = N - 1; i > 0; i--){
            if(arr[i] <= arr[i - 1]){
                num += - ((arr[i] - arr[i - 1]) - 1);
                arr[i - 1] = arr[i - 1] + ( (arr[i] - arr[i - 1]) - 1);
            }
        }

        System.out.println(num);
    }
}
