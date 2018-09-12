import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 11..
 */
public class Test2485 {
    public static void main(String[] args) throws IOException{

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
        int result = streetTrees.getSubtractArr().getDivision().getResult();
//        streetTrees.printArr();
//        System.out.println(streetTrees.num);
//        System.out.println(streetTrees.num);
        System.out.println(result);
    }
}

class StreetTrees{

    int[] streetTreesArr;
    int[] subtractArr;
    int minValue;

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


    public StreetTrees getDivision(){
        minValue =  subtractArr[0];
        int length = subtractArr.length;
        int i = 0;

        while(i < length){
            if(subtractArr[i] % minValue != 0){
                minValue = minValue / 2;
            }else{
                i++;
            }
        }

        return this;
    }

    public int getResult(){
        int result = 0;
        for(int i = 0; i < subtractArr.length; i++){
            result += (subtractArr[i] / minValue) - 1;
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