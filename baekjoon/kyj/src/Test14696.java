import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * Created by yong on 2018. 12. 3..
 */
public class Test14696 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 14696번 딱지놀이
         * solution : 1. 4까지 표현할 수 있는 들어가는 배열 선언 뒤, for문을 돌리면서 인덱스에 값을 늘려서 비교.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gameCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < gameCnt; i++){
            String[] strs1 = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(strs1).mapToInt(Integer::parseInt).toArray();
            int[] myArr = new int[5];
            for(int j = 1; j < arr.length; j++){
                myArr[arr[j]]++;
            }

            String[] strs2 = br.readLine().trim().split(" ");
            int[] arr2 = Arrays.stream(strs2).mapToInt(Integer::parseInt).toArray();
            int[] friendArr = new int[5];
            for(int j = 1; j < arr2.length; j++){
                friendArr[arr2[j]]++;
            }

            String result = "D";
            for(int j = myArr.length - 1; j >= 1; j--){
                if(myArr[j] > friendArr[j]) {
                    result = "A";
                    break;
                } else if(myArr[j] < friendArr[j]) {
                    result = "B";
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
