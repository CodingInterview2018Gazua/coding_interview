

/**
 * Created by yong on 2018. 9. 24..
 */
public class Programmers42584 {
    public static void main(String[] args) {
        /**
         * description : 프로그래머스 42584번, 주식가격, 가격이 유지되는 기간을 구해서 return
         * solution : 1. for loop 두 개를 만든다
         *            2. 첫 번째 for loop은 배열 length 만큼
         *            3. 두 번째 for loop은 기준 인덱스 부터 배열 length - 1 만큼 돌면서
         *            4. 가격이 유지되면 duration을 증가시켜 준다.
         */
        int[] prices = {498, 501, 470, 489};
        int priceLength = prices.length;
        int[] answer = new int[priceLength];
        int duration = 0;
        for(int i = 0; i < priceLength; i++){
            int stand = prices[i];
            for(int j = i; j < priceLength - 1; j++){
                if(stand <= prices[j]) duration++;
                else break;
            }
            answer[i] = duration;
            duration = 0;
        }

        for(int j = 0 ; j < priceLength; j++){
            System.out.println(answer[j]);
        }
    }
}


