import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yong on 2018. 10. 9..
 */
public class Programmers42626 {
    public static void main(String[] args) throws IOException{
        /**
         * @description : 프로그래머스 42626번 더 맵게 (힙)
         * @solution : 1. 우선순위 큐를 사용해서 poll 받은 가장 작은 값에 해당 공식을 적용 한뒤, offer한다.
         *             2. 예외 사항은 1)우선 순위 큐 사이즈가 1이 되면 -1을 반환
         *             3. 2) 우선 순위 큐의 가장 작은 값이 0이 있다면 -1을 반환하도록 한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int[] scoville = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int K = Integer.parseInt(br.readLine());
        solution(scoville, K);
    }

    public static int solution(int[] scoville, int K) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            priorityQueue.offer(scoville[i]);
        }

        int answer = 0;
        if(priorityQueue.peek() <= 0)
            return -1;

        while(priorityQueue.peek() < K){
            if(priorityQueue.size() <= 1) {
                answer = -1;
                break;
            }

            int min = priorityQueue.poll();
            priorityQueue.offer(min + priorityQueue.poll() * 2);
            answer ++;
        }

        System.out.println(answer);

        return answer;
    }
}
