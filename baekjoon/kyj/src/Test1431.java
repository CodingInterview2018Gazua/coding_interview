import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 10..
 */
public class Test1431 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1431번 시리얼 번호 (정렬)
         * 아래 주어진 조건으로 정렬을 한다.
         * 1. A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
           2. 만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
           3. 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
         * solution : comparable interface 를 사용.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Serial[] serialArr = new Serial[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            serialArr[i] = new Serial(st.nextToken());
        }

        Arrays.sort(serialArr);

        for(int i = 0; i < serialArr.length; i++){
            System.out.println(serialArr[i].getSerialNumber());
        }
    }
}

class Serial implements Comparable<Serial>{

    public String serialNumber;

    Serial(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getLength(String serialNumber1, String serialNumber2){
        return ( serialNumber1.length() - serialNumber2.length() );
    }

    public int compareSum(String serialNumber1, String serialNumber2){
        return ( getSum(serialNumber1) - getSum(serialNumber2) );
    }

    public int getSum(String serialNumber){
        int sum = 0;
        for(int i = 0; i < serialNumber.length(); i++){
            if(Character.isDigit(serialNumber.charAt(i))){
                sum += (Integer.parseInt(serialNumber.charAt(i) + ""));
            }
        }

        return sum;
    }

    public int compareAlpa(String serialNumber1, String serialNumber2){
        return serialNumber1.compareTo(serialNumber2);
    }

    @Override
    public int compareTo(Serial serial) {
        int result = getLength(this.serialNumber, serial.getSerialNumber());
        if(result != 0)
            return result;

        result = compareSum(this.serialNumber, serial.getSerialNumber());

        if(result != 0)
            return result;

        result = compareAlpa(this.serialNumber, serial.getSerialNumber());

        return result;
    }
}