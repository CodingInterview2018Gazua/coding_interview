package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test15874 {
    public static Map<String, Integer> alpaMap = new HashMap<>();
    public static String[] alpa = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n","o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static void main(String[] args) throws IOException {
        /**
         * description : 백준 15874번 Caesar Cipher
         * solution : 1. for문을 1번만 쓰기 위해서 알파벳 : 인덱스를 가지고 있는 키를 만든다.
         *            2. for문을 돌면서, 입력된 문자가 알파벳 배열에 속하는지 확인하고
         *            3. 26을 초과하는 경우를 생각하여, (알파벳 인덱스  + 움직여야 하는 인덱스) % 26을 해준다.
         *            4. 대문자인경우 대문자로 변환하여 출력해준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

        initMap();

        int moveIdx = arr[0];
        String[] msg = br.readLine().split("");
        for(int i = 0; i < arr[1]; i++){
            String tmp = msg[i].toLowerCase();
            boolean result = Arrays.stream(alpa).anyMatch(tmp::equals);
            if (result) {
                int idx = (alpaMap.get(tmp) + moveIdx) % 26;
                if(Character.isUpperCase(msg[i].charAt(0))){
                    System.out.print(alpa[idx].toUpperCase());
                }else{
                    System.out.print(alpa[idx]);
                }
            }else{
                System.out.print(msg[i]);
            }
        }
    }

    public static void initMap(){
        for (int i = 0; i < alpa.length; i++){
            alpaMap.put(alpa[i], i);
        }
    }
}
