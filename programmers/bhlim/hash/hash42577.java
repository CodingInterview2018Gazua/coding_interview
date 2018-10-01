package programers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class hash42576 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
        각각 문자열이 다른 문자열의 startsWith인지 체크 합니다. 이때 자신과 비교를 안하게 자신의 인덱스면 그냥 넘어 갑니다
     */

    public boolean solution(String[] phone_book) {
        for(int i = 0; i < phone_book.length; i++) {
            String selected = phone_book[i];

            for(int j = 0; j < phone_book.length; j++) {
                if(j == i)
                    continue;

                String target = phone_book[j];

                if(target.startsWith(selected)) {
                    return false;
                }
            }
        }

        return true;
    }

}