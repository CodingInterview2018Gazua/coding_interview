import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongjin on 2018-09-21.
 */
public class Programmers42577 {
    public static void main(String[] args){
        String[] phone_book = {"166", "16", "165"};
//        String[] phone_book = {"123", "456", "789"};
//        String[] phone_book = {"125", "1223", "1235", "567", "88"};

        int phoneBookLength = phone_book.length;

        String str;
        boolean result = true;
        Loop1: for(int i = 0; i < phoneBookLength; i++){
            str = phone_book[i];
            for(int j = 0; j < phoneBookLength; j++){
                if(i == j){
                    continue;
                }

                if(phone_book[j].contains(str)) {
                    result = false;
                    break Loop1;
                }
            }
        }

        System.out.println(result);
    }
}
