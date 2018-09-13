import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Test1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<Integer>();

        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1;i <= N; i++) {
            deque.add(i);
        }

        while(!deque.isEmpty()) {
            for(int i = 0; i < M-1; i++) {
                deque.addLast(deque.removeFirst());
            }
            sb.append(deque.removeFirst() + ", ");
        }

        System.out.println(sb.toString().substring(0, sb.length() - 2) + ">");
    }
}