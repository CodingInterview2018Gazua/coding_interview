import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yongjin on 2018-09-16.
 */
public class Test6996 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 6996번 에너그램 (첫 번째 문자열의 알파벳 순서를 바꿔서 두 번째 문자열을 만들 수 있을 때, 이를 에너그램이라고 한다.)
         * solution : 입력 받은 문자열을 Character Array로 만들어서 두 번째 배열의 문자 하나하나를 기준으로
         *            반복문을 돌려가며 첫 번째 배열에 알파벳이 있는지 검사한다. 주의 할 점은 두 배열의 크기가 다르면 에너그램이 성립할 수 없다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            char[] strArr1 = str1.toCharArray();
            char[] strArr2 = str2.toCharArray();

            int length1 = strArr1.length;
            int length2 = strArr2.length;

            boolean isAnagrams = true;

            if(length1 == length2) {
                Loop1:
                for (int j = 0; j < length2; j++) {
                    Loop2:
                    for (int k = 0; k < length1; k++) {
                        if (strArr1[k] != 0 && strArr2[j] == strArr1[k]) {
                            strArr1[k] = 0;
                            break Loop2;

                        }

                        if (k + 1 == length1) {
                            isAnagrams = false;
                            break;
                        }
                    }
                }
            }else{
                isAnagrams = false;
            }

            String result = str1 + " & " + str2 + " are ";
            result += (isAnagrams) ? "anagrams." : "NOT anagrams.";
            System.out.println(result);
        }
    }
}