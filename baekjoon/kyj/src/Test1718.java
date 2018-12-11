import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 9. 16..
 */
public class Test1718 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1718번 암호
         * solution : 첫 번째 문자열(평문)을 기준으로 반복문을 돌리면서 두 번째 문자열(암호키)을
         *            평문에서 뺀 만큼의 문자로 이동한다.
         * 참고 : 소문자 알파벳 아스키코드 97 ~ 122, 대문자 알파벳 아스키 코드 65 ~ 90
         */
        final int ALPHABATCNT = 26;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] strArr1 = str1.toCharArray();
        char[] strArr2 = str2.toCharArray();

        int length1 = strArr1.length;
        int length2 = strArr2.length;

        String result = "";
        int a = (int)'a';

        for(int i = 0; i < length1; i++){
            char resultChar = ' ';

            if(strArr1[i] != ' ') {
                int matchIdx = i % length2;
                int tmp = (int) strArr1[i] - (int) strArr2[matchIdx];
                int resultAsc;

                if (tmp > 0) {
                    resultAsc = a + tmp - 1;
                }else {
                    resultAsc = ALPHABATCNT + tmp;
                    resultAsc = a + resultAsc - 1;
                }

                resultChar = (char)resultAsc;
            }
            result += resultChar;
        }

        System.out.println(result);
    }
}
