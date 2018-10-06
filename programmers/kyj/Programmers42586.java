import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by yong on 2018. 10. 6..
 */
public class Programmers42586 {
    public static void main(String[] args) throws IOException {
        /**
         * @description : 프로그래머스 42587번 스택/큐 기능개발
         * @solution : 1. 우선순위를 가지고 있는 큐와 개발 속도를 가지고 있는 큐를 만든다.
         *             2. 우선순위를 가지고 있는 큐의 맨 앞부터 개발 완성도가 100%에 달할때 까지 Percentage를 더해준다.
         *             3. 맵을 만들고 소요일자를 KEY로 만들어 배포되는 기능의 갯수를 같이 세어 Return 한다.\
         *             * 처음에 Hashmap을 만들어서 버그가 있었는데 HashMap은 순서대로 데이터를 가져오는 걸 보장하지 못한다.
         *             따라서 순서대로 데이터를 가져오고 싶으 LinkedHashMap과 TreeMap을 사용하면된다.
         *             LinkedHashMap: 입력된 순서대로 데이터가 출력
         *             TreeMap: 입력된 key의 소트순으로 데이터가 출력
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs1 = br.readLine().trim().split(" ");
        int[] progresses = Arrays.stream(strs1).mapToInt(Integer::parseInt).toArray();

        String[] strs2 = br.readLine().trim().split(" ");
        int[] speeds = Arrays.stream(strs2).mapToInt(Integer::parseInt).toArray();

        int[] answer = solution(progresses, speeds);
        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();
        Map<Integer, Integer> hm = new TreeMap();

        for(int i = 0; i < progresses.length; i++){
            progressQueue.offer(progresses[i]);
            speedQueue.offer(speeds[i]);
        }

        int index = 0;
        while(!progressQueue.isEmpty()){
            if(progressQueue.peek() >= 100){
                progressQueue.poll();
                speedQueue.poll();
                if(hm.containsKey(index)){
                    hm.put(index, hm.get(index) + 1);
                }else{
                    hm.put(index, 1);
                }
            }else{
                int size = progressQueue.size();
                while(size-- > 0){
                    int v1 = progressQueue.poll();
                    int v2 = speedQueue.poll();
                    speedQueue.offer(v2);
                    progressQueue.offer(v1 + v2);
                }
                index++;
            }
        }

        Iterator iterator = hm.entrySet().iterator();
        int[] answer = new int [hm.size()];
        int k = 0;
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            answer[k] = (int)mentry.getValue();
            k++;
        }

        return answer;
    }
}
