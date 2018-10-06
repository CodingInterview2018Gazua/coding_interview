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
         * @solution :
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
        HashMap<Integer, Integer> hm = new HashMap();

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
