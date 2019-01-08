import java.util.Arrays;

public class Programmers42883 {
    public static void main(String[] args){
//        String number   = "1924";
//        int    k        = 2;

        String number   = "4177252841";
        int    k        = 9;

//        String number = "1231234";
//        int    k        = 3;

//        String number = "1000001";
//        int    k        = 6;

        String answer = solution(number, k);
        System.out.println(answer);
    }

    public static String solution(String number, int k) {
        String answer = "";
        int[] answerArr = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        int start = 0;
        int length = number.length() - k; //최종 return value의 length
        for(int i = 0; i < length; i++){
            int max = 0;
            int index = 0;
            int leftLength =  length - answer.length();
            for(int j = start; j < answerArr.length; j++) {
                if(leftLength > answerArr.length - j){
                    break;
                }

                if (max < answerArr[j]){
                    max = answerArr[j];
                    index = j;
                }
            }

            start = index + 1;
            answer += max;
        }

        if(answer.equals("")){
            answer += 0;
        }

        return answer;
    }
}
