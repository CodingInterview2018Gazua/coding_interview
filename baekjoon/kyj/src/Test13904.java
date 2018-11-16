import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by yong on 2018. 11. 15..
 */
public class Test13904 {
    public static void main(String[] args) throws IOException{
        /**
         * solution : 백준 13904번 과제
         * description : 1. 리스트에 과제를 끝낼 때의 점수를 기준으로 정렬된 객체를 넣는다. (Greedy)
         *               2. day를 가지고 있는 set을 만들어 day가 없을 때 점수를 Sum 시키고
         *               3. day가 있으면 day를 -1 시켜준다.
         *               * set의 용도는 set에 들어갈 수 있다면, 마감일을 지킬 수 있다고 판단하는 것.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Work> tmp = new ArrayList();
        for(int i = 0; i < N; i++) {
            String[] strs = br.readLine().trim().split(" ");
            int d = Integer.parseInt(strs[0]);
            int w = Integer.parseInt(strs[1]);
            Work work = new Work(d, w);
            tmp.add(work);
        }

        Collections.sort(tmp);

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < tmp.size(); i++) {
            int day = tmp.get(i).day;
            int work = tmp.get(i).work;
            while (day > 0){
                if(!set.contains(day)){
                    set.add(day);
                    sum += work;
                    break;
                }
                day -= 1;
            }
        }

        System.out.println(sum);
        /*
        for(int i = 0; i < tmp.size(); i++){
            System.out.println(tmp.get(i).day + ", " + tmp.get(i).work);
        }
        */
    }
}

class Work implements Comparable<Work>{

    int day;
    int work;

    Work(int day, int work){
        this.day = day;
        this.work = work;
    }

    @Override
    public int compareTo(Work o) {
        return o.work - this.work;
    }
}
