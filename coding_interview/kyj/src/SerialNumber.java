import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 10..
 */
public class SerialNumber {
    public static void main(String[] args) throws IOException{
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
        return (  getSum(serialNumber1) - getSum(serialNumber2) );
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