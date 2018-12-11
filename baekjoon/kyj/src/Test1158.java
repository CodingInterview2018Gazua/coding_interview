import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Test1158 {
    public static void main(String[] args) throws IOException {
        /**
         * description : 백준 1158번 조세퍼스
         * solution : 1. 양쪽 끝에서 삽입과 삭제가 가능한 Deque를 사용한다.
         *            2. M - 1 만큼 Deque의 앞에서 값을 꺼내 뒤에다 삽입 한 뒤,
         *            3. 맨 앞의 값을 StringBuilder에 append 시킨다.
         *            4. 큐가 Empty 될 때까지 계속한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<Integer>();

        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while(!deque.isEmpty()) {
            for(int i = 0; i < M - 1; i++) {
                deque.addLast(deque.removeFirst());
            }
            sb.append(deque.removeFirst() + ", ");
        }

        System.out.println(sb.toString().substring(0, sb.length() - 2) + ">");
    }
}