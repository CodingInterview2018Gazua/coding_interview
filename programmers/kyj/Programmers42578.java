import java.util.HashMap;
import java.util.Map;

/**
 * Created by yong on 2018. 9. 23..
 */
public class Programmers42578 {
    public static void main(String[] args){
        /**
         * description :  프로그래머스 42578번 위장
         * solution : 1. 각 옷 종류의 벌 수에 + 1을 한 뒤, 전체 곱을 한다.
         *            2. 계속 더해진 sum에 - 1를 한다
         */
//        String[][] clothes = {{"crow_mask", "face"}};
//        String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};
//        String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"},{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup","face"}};
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup","face"}};
        Map<String, Integer> hm = new HashMap<>();

        int clothesSize = clothes.length;
        for(int i = 0; i < clothesSize; i++){
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }

        int sum = 1;
        for (String key : hm.keySet()) {
            sum *= hm.get(key) + 1;
        }

        int answer = sum - 1;
        System.out.println(answer);
    }
}
