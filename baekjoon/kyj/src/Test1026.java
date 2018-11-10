import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test1026 {
    public static void main(String[] args)throws IOException {
        /**
         * description : 백준 1026번 보물
         * solution :   1. B배열의 위치별 크기를 표시한 tmp 배열을 하나 만든다.
         *              2. tmp 배열을 만드는 조건은 다음값보다 클 때 +1을 하고
         *              3. 원소의 값이 같을 수가 있으므로 값이 같은 경우, 뒤에 위치하면 +1을 해준다.
         *              4. A(첫 번째 입력받은 배열)를 내림차순으로 Sorting 한다.
         *              5. A를 tmp에 위치한 인덱스로 변환시킨다.
         *              6. 문제에 맞게 연산한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs1 = br.readLine().trim().split(" ");
        String[] strs2 = br.readLine().trim().split(" ");

        int[] B = Arrays.stream(strs2).mapToInt(Integer::parseInt).toArray();

        int[] tmp = new int[N];
        for(int i = 0; i < N; i++){
            int seq = 0;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;

                if (B[i] > B[j] || (i < j && B[i] == B[j]) ) {
                    seq ++;
                }
            }
            tmp[i] = seq;
        }

        Arrays.sort(strs1, (num1, num2) -> Integer.parseInt(num2) - Integer.parseInt(num1));

        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += Integer.parseInt(strs1[tmp[i]]) * B[i];
        }

        System.out.println(sum);

    }
}
