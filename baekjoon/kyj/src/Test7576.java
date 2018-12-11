package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yongjin on 2018-12-10.
 */

public class Test7576 {
    /**
     * description : 백준 7576번 토마토
     * solution : 1. 큐를 사용하여 큐에 익은 토마토의 위치를 넣어주고 큐가 empty 될 때까지 BFS 를 진행한다.
     *            2. 토마토가 익는 최소 일자를 출력해야 하기 때문에 다음 위치 = 이전위치의 + 1 을 연산한다.
     */
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        BFS(arr, N, M);
    }

    public static void BFS(int[][] arr, int N, int M) {
        Queue<Position> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    q.add(new Position(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Position position = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = position.x + dx[i];
                int nextY = position.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                if (arr[nextX][nextY] != 0) {
                    continue;
                }

                arr[nextX][nextY] = arr[position.x][position.y] + 1;
                q.add(new Position(nextX, nextY));
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }

        System.out.println(max - 1);

    }
}

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
