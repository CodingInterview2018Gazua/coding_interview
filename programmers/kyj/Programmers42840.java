import java.util.ArrayList;
import java.util.List;

public class Programmers42840 {
    public static void main(String[] args){
        /**
         * description : 프로그래머스 완전 탐색 > 42840번 모의고사
         * solution : 1. 찍는 방식의 규칙대로 배열을 만든다. (A, B, C)
         *            2. answers 배열만큼 찍는 수 배열도 만든 뒤, (tmpA, tmpB, tmpC)
         *            3. 각각의 정답 수를 구해준다.
         *            4. 가장 정답 수가 많은 번호를 return.
         */
//        int[] answer = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] answer = {1, 3, 2, 4, 2};
        int[] test = solution(answer);
        for(int num : test){
            System.out.println(num);
        }
    }

    public static int[] solution(int[] answers) {
        int[] A = {1, 2, 3, 4, 5};
        int[] tmpA = new int[answers.length];
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] tmpB = new int[answers.length];
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] tmpC = new int[answers.length];

        for(int i = 0; i < answers.length; i++){
            tmpA[i] = A[i % A.length];
            tmpB[i] = B[i % B.length];
            tmpC[i] = C[i % C.length];
        }

        int[] tmp = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == tmpA[i]){
                tmp[0]++;
            }

            if(answers[i] == tmpB[i]){
                tmp[1]++;
            }

            if(answers[i] == tmpC[i]){
                tmp[2]++;
            }
        }

        List<Integer> list = new ArrayList<>();

        int max = Math.max(Math.max(tmp[0], tmp[1]), tmp[2]);
        for(int i = 0; i < tmp.length; i++){
            if(tmp[i] == max){
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i ++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
