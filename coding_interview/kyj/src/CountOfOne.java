import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 5..
 * Cracking the coding Interview 5-3 문제풀이
 */
public class CountOfOne {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        Binary binary = new Binary(A);

        int maxResult = binary.getMaxMinOneCount("max");
        int minResult = binary.getMaxMinOneCount("min");

        System.out.println("min = " + minResult + ", max = " + maxResult);

    }
}

class Binary {

    public int oneCount; // 1의 갯수
    public int initDecimalNumber; //초기 10진수 값
    public int decimalNumber; //10진수

    Binary(int decimalNumber){
        this.decimalNumber = decimalNumber;
        this.initDecimalNumber = decimalNumber;
        char[] tmpArr = getCharBinary(decimalNumber);
        this.oneCount = getOneCount(tmpArr);
    }

    /**
     * 이진수 변환
     * @param num int
     * @return binaryChar char[]
     */
    public char[] getCharBinary(int num){
        String binary = Integer.toBinaryString(num);
        char[] binaryChar = binary.toCharArray();
        return binaryChar;
    }

    /**
     * 이진 수의 1의 갯수
     * @param arr char[]
     * @return oneCount int
     */
    public int getOneCount(char[] arr){
        int oneCount = 0;
        for (char binary: arr) {
            if(binary == '1'){
                oneCount++;
            }
        }

        return oneCount;
    }

    /**
     * 초기 입력된 이진수 1의 갯수과 같은 1의 갯수를 가진 최대값 또는 최소값을 반환
     * @param index
     * @return
     */
    public int getMaxMinOneCount(String index){
        while(true){
            decimalNumber = (index.equals("max")) ? --decimalNumber : ++decimalNumber;
            char[] binaryChar = getCharBinary(decimalNumber);
            int tmpCnt = getOneCount(binaryChar);
            if(tmpCnt == oneCount){
                int temp = decimalNumber;
                decimalNumber = initDecimalNumber;
                return temp;
            }
        }
    }
}
