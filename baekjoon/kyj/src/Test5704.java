import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 9. 17..
 */
public class Test5704 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 5704번 팬그램
         * solution : 입력받은 문자열(평문)을 기준으로 반복문을 돌리면서 알파벳 배열에 원소가 있으면
         *            카운트 배열에 숫자를 더한다. 카운트 배열에 0이 검색되면 펜그램이 N으로 판별한다.
         */
        final int ALPHABATCNT = 26;
        char[] alphaArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = br.readLine().trim()) != null && !line.equals("*")){
            int[] cntArr = new int[ALPHABATCNT];
            char[] charArr = line.toCharArray();
            int length1 = charArr.length;
            int length2 = alphaArr.length;
            char isPangram = 'Y';

            if(charArr.length >= ALPHABATCNT) {
                for (int i = 0; i < length1; i++) {
                    for (int j = 0; j < length2; j++) {
                        if (charArr[i] == alphaArr[j]) {
                            cntArr[j]++;
                        }
                    }
                }

                for (int i = 0; i < length2; i++) {
                    if (cntArr[i] == 0) {
                        isPangram = 'N';
                        break;
                    }
                }
            }else{
                isPangram = 'N';
            }

            System.out.println(isPangram);
        }
    }
}
