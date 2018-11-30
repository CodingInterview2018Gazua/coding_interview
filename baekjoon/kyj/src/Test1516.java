import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yong on 2018. 11. 30..
 */
public class Test1516 {
    public static ArrayList<Integer>[] list;
    public static int[] indegree;
    public static int[] result;
    public static int[] times;
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1516번 게임개발
         * solution : 1. 위상정렬 알고리즘을 사용한다.
         *            2. Max 시간의 임계경로 설정이 필요하다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        indegree = new int[N + 1];
        result = new int[N + 1];
        times = new int[N + 1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= N; i++){
            String[] strs = br.readLine().trim().split(" ");
            for(int j = 0; j < N; j++){
                int tmp = Integer.parseInt(strs[j]);
                if(strs[j].equals("-1")) break;

                if(j == 0) {
                    times[i] = Integer.parseInt(strs[j]);
                    continue;
                }

                list[tmp].add(i);
                indegree[i]++;
            }
        }

        topologySort();
    }

    public static void topologySort(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                result[i] = times[i];
            }
        }

        while (!queue.isEmpty()){
            int current = queue.poll();
            for(int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                indegree[next]--;
                //임계경로 설정
                result[next] = Math.max(result[next], result[current] + times[next]);

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i < indegree.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
