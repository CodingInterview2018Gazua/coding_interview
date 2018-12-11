import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 5..
 */
public class Test4597 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 4597번 패리티
         * solution : 패리티의 1의 갯수의 홀수/짝수 여부를 판단하여 마지막 스트링을 찾아서 출력해 줌
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            if(line.equals("#")) {
                break;
            }

            BitString bitString = new BitString(line);
            String returnStr = bitString.getCharBinary().getOneCount().getLastChar().getFullBitString();
            System.out.println(returnStr);
        }
    }
}

class BitString{

    public char[] binaryChar; // 입력 이진수를 char[]로 변환한 값
    public String binaryStr; // 초기 입력 이진수
    public int oneCount; // 1의 갯수
    public int binaryLength; //초기 입력 이진수의 길이
    public char lastChar; // 마지막 비트 스트링

    BitString(String binaryStr){
        this.binaryStr = binaryStr;
        this.binaryLength = binaryStr.length();
    }

    /**
     * 입력 이진수를 char[]로 반환
     * @return BitString
     */
    public BitString getCharBinary(){
        this.binaryChar = binaryStr.toCharArray();
        return this;
    }

    /**
     * 1의 갯수를 반환
     * @return BitString
     */
    public BitString getOneCount(){
        for(char binary : binaryChar){
            if (binary == '1') {
                this.oneCount++;
            }
        }
        return this;
    }

    /**
     * 마지막 문자열 반환
     * @return BitString
     */
    public BitString getLastChar(){
        this.lastChar = binaryChar[binaryLength - 1];
        return this;
    }

    /**
     * 1과 마지막 문자열에 따라 맞는 문자열 반환
     * @return BitString
     */
    public String getFullBitString(){
        String returnStr = "";
        String tmp = binaryStr.substring(0, binaryLength - 1);
        if(this.lastChar == 'e'){
            returnStr = (oneCount % 2 == 0) ? tmp + "0" : tmp + "1";
        }else{
            returnStr = (oneCount % 2 == 0) ? tmp + "1" : tmp + "0";
        }

        return returnStr;
    }
}
