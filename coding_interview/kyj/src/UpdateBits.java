import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 3..
 */
public class UpdateBits {

    public static int updateBits(int n, int m, int i, int j) {

        if (i >= 32 || j < i) {
            return 0;
        }

        int allOnes = ~0;

        int left = allOnes << (j + 1);
        /*
        String leftBinary = Integer.toBinaryString(left);
        System.out.println(leftBinary);
        */
        int right = ((1 << i) - 1);
        /*
        String rightBinary = Integer.toBinaryString(right);
        System.out.println(rightBinary);
        */
        int mask = left | right; // i ~ j 까지의 마스크 처리
        /*
        String maskBinary = Integer.toBinaryString(mask);
        System.out.println(maskBinary);
        */
        int n_cleared = n & mask; // 마스크와 비교하여 n의 해당 부분을 비워 놓는다
        /*
        String n_clearedBinary = Integer.toBinaryString(n_cleared);
        System.out.println(n_clearedStr);
        */
        int m_shifted = m << i; // m을 i 위치로 옮겨 놓는다.
        /*
        String m_shiftedBinary = Integer.toBinaryString(m_shifted);
        System.out.println(m_shiftedBinary);
        */
        return n_cleared | m_shifted; // 둘을 합친다.
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        /*
        int a = 16;
        String aBinary = Integer.toBinaryString(a);
        System.out.println(aBinary);
        */

        /*
        int b = 1;
        String bBinary = Integer.toBinaryString(a);
        System.out.println(bBinary);
        */

        /*
        int i = 2;
        int j = 3;
        * */

        int c = updateBits(a, b, i, j);

        System.out.println(Integer.toBinaryString(c));
    }

}

