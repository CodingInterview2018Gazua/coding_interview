import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongjin on 2018-09-21.
 */
public class Programmers42577 {
    public static void main(String[] args){
        String[] phone_book = {"1192219", "97674223", "119"};
//        String[] phone_book = {"123", "456", "789"};
//        String[] phone_book = {"125", "1223", "1235", "567", "88"};

        Map<String, Integer> hm = new HashMap<>();

        int phoneBookLength = phone_book.length;
        for(int i = 0; i < phoneBookLength; i++){
            hm.put(phone_book[i], 0);
        }

        String str;
        boolean result = true;
        for(int i = 0; i < phoneBookLength; i++){
            str = phone_book[i];
            for(int j = 0; j < phoneBookLength; j++){
                if(i == j){
                    continue;
                }

                if(phone_book[j].contains(str)) {
                    result = false;
                }
            }
        }

        System.out.println(result);
    }
}
