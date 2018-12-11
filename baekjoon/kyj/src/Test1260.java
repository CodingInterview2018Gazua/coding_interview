import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yong on 2018. 10. 24..
 */
public class Test1260 {

    public static int[][] map;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1206번 dfs와 bfs
         * solution : dfs는 recursive를 이용
         *            bfs는 queue를 이용해서 해결한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int N       = arr[0];
        int M       = arr[1];
        int start   = arr[2];

        map     = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            String[] line = br.readLine().trim().split(" ");
            int[] link = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            map[link[1]][link[0]] = map[link[0]][link[1]] = 1;
        }

        dfs(start, N);

        visited = new boolean[N + 1];
        System.out.println("");

        bfs(start, N);
    }

    public static void dfs(int start, int end){

        if (visited[start]) {
            return;
        }

        System.out.print(start + " ");

        for(int i = 1; i < end + 1; i++) {
            if (map[start][i] == 1) {
                visited[start] = true;
                dfs(i, end);
            }
        }
    }

    public static void bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int n = queue.poll();
            System.out.print(n + " ");
            for(int i = 1; i < end + 1; i++){
                if(map[n][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
