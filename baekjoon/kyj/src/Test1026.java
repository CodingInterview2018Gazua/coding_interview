package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test1026 {
    public static void main(String[] args)throws IOException {
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

                if (B[i] >= B[j]) {
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
