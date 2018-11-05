import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yongjin on 2018-09-04.
 */
public class Test12782 {
    public static void main(String[] args) throws IOException{
        /**
         * 백준 비트 우정지수 (12782번)
         * Input  : 각 테스트케이스의 첫 번째 줄에는 두 이진수 N, M이 주어진다. N, M의 자릿수는 1,000,000을 넘지 않으며, 자릿수는 서로 같다.
         * Output : 각 테스트 케이스마다 두 수의 비트 우정지수를 출력한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            Bit Nbit = new Bit(st.nextToken());
            Bit Mbit = new Bit(st.nextToken());

            int result;
            if(Nbit.calCnt() >= Mbit.calCnt()){
                Nbit.compareBit(Mbit, Nbit);
            }else{
                Nbit.compareBit(Nbit, Mbit);
            }

            result = Nbit.getFriendCnt();
            /*
            System.out.println(" 1의 갯수 " + Nbit.oneCnt);
            System.out.println(" 0의 갯수 " + Nbit.zeroCnt);
            System.out.println(" 1이면서 다른 곳 갯수 " + Nbit.oneIncorrectCnt);
            System.out.println(" 0이면서 다른 곳 갯수 " + Nbit.zeroIncorrectCnt);
            */
            System.out.println(result);
        }
    }
}

class Bit{

    public int oneCnt = 0;
    public int zeroCnt = 0;
    public int oneIncorrectCnt = 0;
    public int zeroIncorrectCnt = 0;
    public String bit;
    public char[] charArr;

    Bit(String bit){
        this.bit = bit;
        this.charArr = bit.toCharArray();
    }

    public int calCnt(){
        int arrLength = charArr.length;
        for(int i = 0; i < arrLength; i++){

            if(charArr[i] == '1'){
                oneCnt++;
            }else{
                zeroCnt++;
            }
        }

        return oneCnt;
    }

    public void compareBit(Bit bit1, Bit bit2){
        int length = bit1.charArr.length;
        for(int i = 0; i < length; i++){
            if(bit1.charArr[i] != bit2.charArr[i] && bit1.charArr[i] == '1'){
                // 1 이면서 다른곳
                oneIncorrectCnt++;
            }else if(bit1.charArr[i] != bit2.charArr[i] && bit1.charArr[i] == '0'){
                // 0 이면서 다른곳
                zeroIncorrectCnt++;
            }
        }
    }

    public int getFriendCnt(){
        return zeroIncorrectCnt;
    }
}