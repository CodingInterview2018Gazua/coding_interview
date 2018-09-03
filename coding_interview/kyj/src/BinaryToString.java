import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 4..
 */
public class BinaryToString {
    /**
     *
     * 5-2
     * Input  : 0과 1 사이 실수, Double 타입
     * Output : 이진수 형태의 String 타입
     *
     */
    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder().append("0.");
        while (num > 0) {
            if (binary.length() > 32) {
                return "ERROR";
            }

            double r = num * 2;

            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Double input = Double.parseDouble(st.nextToken());
        String result = printBinary(input);
        System.out.println(result);
    }
}
