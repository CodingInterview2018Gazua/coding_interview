import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 11. 16..
 */
public class Test10809 {
    public static void main(String[] args) throws IOException{
        /**
         * solution : 백준 10809번 알파벳 찾기
         * description : 1. indexof method를 사용해서 해당 알파벳의 위치를 return 받는다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] alpa = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for(int j = 0; j < alpa.length; j++) {
            System.out.print(str.indexOf(alpa[j]) + " ");
        }
    }
}
