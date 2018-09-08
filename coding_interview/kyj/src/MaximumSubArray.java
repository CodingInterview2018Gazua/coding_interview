import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 9..
 */
public class MaximumSubArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            SubArray subArray = new SubArray(arr);
//            subArray.printArr();

            int result = subArray.getMaxSumArr();

            System.out.println(result);

        }
    }
}

class SubArray{

    public int[] arr; // 입력 배열

    SubArray(int[] arr){
        this.arr = arr;
    }

    /**
     *
     * @description dp를 통해 최대 부분 배열을 구한다.
     */
    public int getMaxSumArr(){
        int N = arr.length;
        int result = arr[0];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = Math.max(sum, 0) + arr[i];
            result = Math.max(sum, result);
        }

        return result;
    }

    public void printArr(){
        System.out.println("======");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println("");
        System.out.println("======");
    }

}

