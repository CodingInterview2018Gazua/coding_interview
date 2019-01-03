public class Programmers42862 {
    public static void main(String[] args){
        /**
         * description : 프로그래머스 탐욕법 > 42862번 체육복
         * solution : 1. 체육복을 잃어버린 학생들에게 번호의 아래 또는 위의 학생이 빌려줄 수 있다.
         *            2. 우선 순위로 체육복을 잃어버린 학생 기준, 아래 학생이 여분 체육복을 가져왔다면 먼저 빌려주고
         *            3. 다음 순위로 체육복을 잃어버린 학생 기준, 위의 학생이 여분 체육복을 빌려준다.
         *            4. 체육복을 가지고 있는 학생만 출력.
         */
        int [] lost = {2, 4};
        int [] reserve = {1, 3};
        int test = solution(5, lost, reserve);
        System.out.println(test);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] arr = new int[31];

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]]++;
        }

        for (int i = 0; i < lost.length; i++) {
            if (arr[lost[i]] != -1) continue;

            if (arr[lost[i] - 1] == 1) {
                arr[lost[i] - 1] = 0;
                arr[lost[i]] = 0;
                continue;
            }

            if (arr[lost[i] + 1] == 1) {
                arr[lost[i] + 1] = 0;
                arr[lost[i]] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] != -1) {
                answer++;
            }
        }

        return answer;
    }
}
