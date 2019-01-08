import java.util.Arrays;

public class Programmers42883 {
    public static void main(String[] args){
        /**
         * description : 프로그래머스 42883번 가장 큰 수
         * solution : 1. 범위를 지정해주고 범위 안에서 가장 큰 수를 추출 하여 리턴하는 문자열에 더해준다.
         *            2. 범위의 시작은 가장 큰 수가 나오면 시작값 (start 값을 바꿔주면서 진행)
         */
//        String number   = "1924";
//        int    k        = 2;

//        String number   = "4177252841";
//        int    k        = 4;

//        String number = "1231234";
//        int    k        = 3;

//         String number = "0";
//         int    k        = 0;

        String number = "123191001"; // 5
        int    k        = 3;

        String answer = solution(number, k);
        System.out.println(answer); //  31103
    }

    public static String solution(String number, int k) {
        int length = number.length() - k;
        int[] answerArr = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        StringBuilder answer = new StringBuilder();

        int start = 0;
        int end = k + 1;

        for (int i = 0; i < length; i++) {
            int max = 0;
            for (int j = start; j < end; j++) {
                if (max < answerArr[j]) {
                    max = answerArr[j];
                    start = j;
                }
            }

            start++;
            end++;
            answer.append(max);
        }

        return answer.toString();
    }
}
