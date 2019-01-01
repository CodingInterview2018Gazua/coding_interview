import java.util.Arrays;

public class Programmers42746 {
    public static void main(String[] args){
        /**
         * solution : 프로그래머스 42746번 정렬 > 가장 큰 수
         * description : 1. 두 수를 비교 할 수 있도록 Comparable을 상속 받는 class를 만든다.
         *               2. compareTo method에서 두 수를 붙여서 비교해보고 정렬이 가능하도록 한다.
         *               3. 원소가 모두 0, 0 인 경우 "0"으로 출력되도록 예외 처리 해준다.
         */
//        int [] numbers = {6, 2, 10};
        int [] numbers = {3, 30, 34, 5, 9};
//        int [] numbers = {0, 0, 0, 0};
//        int [] numbers = {3435, 34, 1, 1};
        System.out.print(solution(numbers));
    }

    public static String solution(int[] numbers){
        Number[] numberArr = new Number[numbers.length];
        String result = "";
        for(int i = 0; i < numbers.length; i++){
            numberArr[i] = new Number(numbers[i]);
        }

        Arrays.sort(numberArr);

        if(numberArr[0].num <= 0){
            return "0";
        }

        for(int i = 0; i < numberArr.length; i++){
            result += numberArr[i].num;
        }

        return result;
    }
}

class Number implements Comparable<Number>{
    public int num;

    public Number(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Number o) {
        int result = 0;
        String tmp1 = String.valueOf(num) + o.num;
        String tmp2 = String.valueOf(o.num) + num;

        if(Integer.parseInt(tmp1) > Integer.parseInt(tmp2)) {
            result = -1;
        }else if(Integer.parseInt(tmp1) < Integer.parseInt(tmp2)) {
            result = 1;
        }

        return result;
    }
}
