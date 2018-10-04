import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Created by yong on 2018. 10. 3..
 */
public class Programmers42587 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

        System.out.print(solution(arr, Integer.parseInt(br.readLine())));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Element> queue = new LinkedList<>();
        int prioritiesLength = priorities.length;
        int k = prioritiesLength;
        while(k > 0){
            k--;
            queue.add(new Element(priorities[k], k));
        }

        int answer = 0;
        int sum = 0;
        while(!queue.isEmpty()){
            Element element = queue.peek();
            int value = element.value;
            int index = element.index;
            for(int i = queue.size() - 2; i > 0; i--){
                if(value <= priorities[i] && sum < queue.size() - 1){
                    sum ++;
                    queue.add(queue.poll());
                    break;
                }else{
                    queue.poll();
                    answer += 1;
                    sum = 0;
                    if(location == index){
                        return answer;
                    }
                }
            }
        }
        /*
        for(int i = 0; i < sorted.length; i ++){
            System.out.println(sorted[i]);
        }
        */
        return answer;
    }

}

class Element{
    int value;
    int index;

    Element(int value, int index){
        this.value = value;
        this.index = index;
    }
}
