/**
 * Created by yongjin on 2018-09-19.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by yongjin on 2018-09-17.
 */
public class Test1009 {
    /**
     * description : 백준 1009번 분산처리.
     * solution : 1. 제곱 수의 일의 자리의 반복 되는 배열을 만든다.
     *            2. 제곱근의 % 연산자에 따라 선택되는 배열을 반환한다.
     *            * 주의점 : %10이 0이 나오는 값은 예외 처리 한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            DistributeComputer dc = new DistributeComputer();
            int result = dc.getComputerNumber(a, b);
            System.out.println(result);
        }
    }
}

class DistributeComputer {

    public int getComputerNumber(int a, int b) {
        int tmpA = a;
        List<Integer> tmp = new ArrayList<Integer>();

        int aa = a % 10;
        if (aa != 0)
            tmp.add(aa);

        Loop1:
        for (int k = 0; k < b; k++) {
            tmpA *= a;
            tmpA = tmpA % 10;
            if (tmpA == 0) {
                tmp.add(10);
                break;
            }

            for (int j = 0; j < tmp.size(); j++) {
                if (tmp.get(j) == tmpA) {
                    break Loop1;
                }

                if (j == tmp.size() - 1) {
                    tmp.add(tmpA);
                    break;
                }
            }
        }

        int share = b % tmp.size();
        int result;
        if (share == 0) {
            result = tmp.get(tmp.size() - 1);
        } else {
            result = tmp.get(share - 1);
        }

        return result;
    }
}
