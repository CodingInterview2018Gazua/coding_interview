public class Programmers42895 {

    public static int answer = -1;
    public static void main(String[] args){
        /**
         * description : 프로그래머스 42895번 N으로 표현 (https://programmers.co.kr/learn/courses/30/lessons/42895?language=java)
         * solution : 나중에 다시 봐야하는 코드
         */
        int cnt = solution(5, 12);
        System.out.println(cnt);
    }

    public static int solution(int N, int number) {
        dfs(N, 0, 0, number, "");
        return answer;
    }

    public static void dfs(int n, int pos, int num, int number, String s) {
        if (pos > 8)
            return;

        if (num == number) {
            if (pos < answer || answer == -1) {
                System.out.println(s);
                answer = pos;
            }
            return;
        }

        int nn = 0;
        for (int i = 0; i < 8; i++) {
            nn = nn * 10 + n;
            dfs(n, pos + 1 + i, num + nn, number, s + "+");
            dfs(n, pos + 1 + i, num - nn, number, s + "-");
            dfs(n, pos + 1 + i, num * nn, number, s + "*");
            dfs(n, pos + 1 + i, num / nn, number, s + "/");
        }
        // dfs(n,pos+1,num*10+n,number,s+"5");
    }

}
