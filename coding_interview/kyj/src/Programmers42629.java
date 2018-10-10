import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by yong on 2018. 10. 3..
 */
public class Programmers42629 {
    public static void main(String[] args) throws IOException{
        /**
         * @description : 프로그래머스 42629번 라면공장 (힙)
         * @solution : 1. 우선순위 큐를 만든다 (공급량 기준으로 정렬 되도록)
         *             2. 날짜가 K일 까지 진행되는 for문을 작성한다.
         *             3. 날짜가 다가오면 우선순위 큐에 담는다. (공급량 기준으로 정렬됨.)
         *             4. 재고를 -1 씩 해주다가 재고가 0이 되면 우선순위 큐에서 poll 하여 재고를 더해준다. 이때 answer 늘려준다.
         *             5. anwser를 return 한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stock = Integer.parseInt(br.readLine());
        String[] strs1 = br.readLine().trim().split(" ");
        int[] dates = Arrays.stream(strs1).mapToInt(Integer::parseInt).toArray();

        String[] strs2 = br.readLine().trim().split(" ");
        int[] supplies = Arrays.stream(strs2).mapToInt(Integer::parseInt).toArray();

        int k = Integer.parseInt(br.readLine());

        System.out.println(solution(stock, dates, supplies, k));
        /*
        for(int i = 0; i < resultList.size(); i++){
            System.out.print(resultList.get(i) + " ");
        }
        */
    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x1, x2) -> x2 - x1);

        int index = 0;
        int answer = 0;
        for (int day = 0; day < k; day++) {
            if (index < dates.length && day >= dates[index]) {
                priorityQueue.offer(supplies[index]);
                index++;
            }

            if (stock <= 0) {
                stock += priorityQueue.poll();
                answer++;
            }

            stock--;
        }

        return answer;
    }
}



