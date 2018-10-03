import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by yong on 2018. 10. 3..
 */
public class Programmers42585 {
    public static void main(String[] args) throws IOException{
        /**
         * @description : 프로그래머스 스택/큐 - 쇠막대기,
         *                https://programmers.co.kr/learn/courses/30/lessons/42585
         * @solution : 1. 스택을 만든다.
         *             2. '(' 가 나오면 스택에 넣어주고
         *             3. ')'가 나오면 이전 문자를 조회해서 '(' 이면 레이저이기 때문에 스택에 쌓여 있는 막대기 갯수를 더해준다.
         *             4. ')'가 나왔을 때, 이전 문자가 ')' 인 경우는 막대기의 끝이기 때문에 잘리는 막대기 갯수에 +1을 해준다.
         *             * 쇠막대기 (백준 10799번)과 같음.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = solution(br.readLine());
        System.out.println(answer);
    }

    public static int solution(String arrangement){
        char[] arrangements = arrangement.toCharArray();
        int arrangementsLength = arrangements.length;
        Stack<Character> stack = new Stack();
        int answer = 0;
        for(int i = 0; i < arrangementsLength; i++){
            if(arrangements[i] == '(') {
                stack.add(arrangements[i]);
            }else{
                stack.remove(stack.size() - 1);
                if(arrangements[i - 1] == '(') {
                    answer += stack.size();
                }else{
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
