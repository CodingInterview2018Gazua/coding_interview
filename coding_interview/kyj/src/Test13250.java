/**
 * Created by yongjin on 2018-09-20.
 */
import java.util.*;

public class Test13250{
    static final int maxn = 1111111;
    static double[] cache = new double[maxn];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cache[0] = 0.0;
        cache[1] = 1.0;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= 6; j++){
                if (i - j >= 0){
                    cache[i] += (1.0 / 6.0) * (cache[i - j] + 1);
                }else{
                    cache[i] += (1.0 / 6.0);
                }
            }
        }
        System.out.printf("%.16f\n", cache[n]);
    }
}