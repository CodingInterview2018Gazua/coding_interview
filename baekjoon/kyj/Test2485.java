import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 11..
 */
public class Test2485 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 2485번 모든 가로수의 간격이 같게 되는 심어야 하는 최소한의 가로수 수를 구하라.
         * solution : 유클리드 호제법을 이용한 GCD(Greatest Common Devisor)를 구해서 푼다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] streetTreesArr = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            streetTreesArr[i] = Integer.parseInt(st.nextToken());
        }

//        int[] streetTreesArr = {1, 3, 7, 13};
//        int[] streetTreesArr = {2, 6, 12, 18};

        StreetTrees streetTrees = new StreetTrees(streetTreesArr);
        int result = streetTrees.getSubtractArr().getGcd().getResult();
        System.out.println(result);
    }
}

class StreetTrees{

    int[] streetTreesArr;
    int[] subtractArr;
    int gcd;

    public StreetTrees(int[] streetTreesArr){
        this.streetTreesArr = streetTreesArr;
        subtractArr = new int[this.streetTreesArr.length - 1];
    }

    public StreetTrees getSubtractArr(){
        for(int i = 0; i < streetTreesArr.length - 1; i++){
            subtractArr[i] = streetTreesArr[i + 1] - streetTreesArr[i];
        }

        return this;
    }

    public StreetTrees getGcd(){
        gcd = getGcd(subtractArr[0], subtractArr[1]);
        for(int i = 2; i < subtractArr.length; i++) {
            gcd = getGcd(gcd, subtractArr[i]);
        }

        return this;
    }

    public int getGcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return getGcd(b,a % b);
    }

    public int getResult(){

        int result = 0;
        for(int i = 0; i < subtractArr.length; i++){
            result += (subtractArr[i] / gcd) - 1;
        }

        return result;
    }

    public void printArr(){
        for(int i = 0; i < subtractArr.length; i++){
            if(subtractArr[i] != 0)
                System.out.println(subtractArr[i]);
        }
    }
}