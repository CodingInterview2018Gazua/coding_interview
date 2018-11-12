package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test15786 {
    public static void main(String[] args) throws IOException {
        /**
         * description : 백준 15786번 Send me the money
         * solution : 1. for 문을 3중으로 돌린다.
         *            2. 첫 번째 for 문은 입력 문자열(포스트잇에 문자열) 만큼 돌린다.
         *            3. 두 번째 for 문은 첫 번째 문자열(기억 문자열)의 원소 갯수 만큼 돌린다.
         *            4. 세 번째 for 문은 입력 문자열 원소를 돌리면서 문자 비교를 통해 기억 문자열의 끝에 도달하면 true
         *            5. 문자열이 같더라도 기억 문자열은 끝에 도달하지 못했지만 포스트잇 문자열이 끝에 도달하면 false
         *            6. 문자열이 다르더라도 기억 문자열은 끝에 도달하지 못했지만 포스트잇 문자열이 끝에 도달하면 false를 반환한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().trim().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        String[] S = br.readLine().trim().split("");
        for(int i = 0; i < M; i++){
            int index = 0;

            String[] str = br.readLine().trim().split("");

                loop1: for(int j = 0; j < N; j++) {

                    loop2: for(int k = index; k < str.length; k++){

                    if(S[j].equals(str[k])){

                        if(j == N - 1){
                            System.out.println("true");
                            break loop1;
                        }

                        if(k == str.length - 1 && j < N ){
                            System.out.println("false");
                            break loop1;
                        }

                        index = k + 1;
                        break loop2;
                    }

                    if(k == str.length - 1) {
                        System.out.println("false");
                        break loop1;
                    }
                }
            }
        }
    }
}
