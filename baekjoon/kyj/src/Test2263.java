import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 15..
 */
public class Test2263 {

    static int[] inOrderArr = new int[100000]; // in order
    static int[] postOrderArr = new int[100000]; // post order
    static int[] position = new int[100001]; //

    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 2263번 이진트리의 in order와 post order의 값을 보고 pre order로 순회된 값을 구하여라
         * solution :
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            inOrderArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            postOrderArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            position[inOrderArr[i]] = i;
        }

        solve(0, N - 1, 0, N - 1);

    }

    public static void solve(int inStart, int inEnd, int postStart, int postEnd){
        if (inStart > inEnd || postStart > postEnd)
            return;

        int root = postOrderArr[postEnd];

        System.out.print(root + " ");

        int p = position[root];

        // in order에서 루트 왼쪽 자식이 몇개 있는지 저장
        int left = p - inStart;

        // 루트를 기준으로 왼쪽으로 이동
        solve(inStart, p - 1, postStart, postStart + left - 1);

        // 루트를 기준으로 오른쪽으로 이동
        solve(p + 1, inEnd, postStart + left, postEnd - 1);
    }

}
