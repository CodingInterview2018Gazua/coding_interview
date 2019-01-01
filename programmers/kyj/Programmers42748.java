import java.util.Arrays;

public class Programmers42748 {
    public static void main(String[] args){
        /**
         * description : 프로그래머스 42748번 [정렬] k번째 수,
         * solution : 1. 입력받은 start index 와 end index의 범위로 다른 tmp배열에 잘라서 넣어준다.
         *            2. tmp 배열을 sorting 시킨다.
         *            3. 입력받은 위치의 값을 result 배열에 넣어서 return.
         */
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        solution(array, commands);
    }

    public static int[] solution(int[] array, int[][] commands){
        int startIdx, endIdx, idx, k;
        int[] tmpArray;
        int[] answer    = new int[commands.length];
        for(int i = 0; i < commands.length; i ++){
            startIdx    = commands[i][0];
            endIdx      = commands[i][1];
            idx         = commands[i][2];
            tmpArray    = new int[endIdx - startIdx + 1];
            k           = 0;
            for(int j = startIdx - 1; j < endIdx; j ++){
                tmpArray[k++] = array[j];
            }

            Arrays.sort(tmpArray);

            answer[i] = tmpArray[idx - 1];
        }

        return answer;
    }
}
