import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by yong on 2018. 10. 3..
 */
public class Programmers42587 {
    public static void main(String[] args) throws IOException{
        /**
         * @description : 프로그래머스 스택/큐 42587번 프린터
         * @solution : 1. 대기 목록의 가장 앞의 문서를 꺼내므로 Queue를 세팅한다.
         *             2. 중요도와 위치를 저장해야 하므로 Class에 두 멤버변수를 선언한다.
         *             3. Queue 에서 꺼낸 문서의 우선순위가 가장 큰 지 검사하는 isMaxValue 함수를 작성한다.
         *             4. Queue 에서 꺼낸 문서가 우선순위가 가장 크다면 location과 비교 한 뒤, Return.
         *             5. 아니라면 Queue 끝에 offer를 해준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

        System.out.print(solution(arr, Integer.parseInt(br.readLine())));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Element> queue = new LinkedList<>();
        int prioritiesLength = priorities.length;
        for(int i = 0; i < prioritiesLength; i++){
            queue.offer(new Element(priorities[i], i));
        }

        int answer = 0;
        while(!queue.isEmpty()){
            Element element = queue.poll();
            int value = element.value;
            int index = element.index;
            if(isMaxValue(queue, value)){
                answer++;
                if(location == index) break;
            }else{
                queue.offer(element);
            }
        }

        return answer;
    }

    public static boolean isMaxValue(Queue queue, int value){
        Iterator it = queue.iterator();
        boolean isMax = true;
        while(it.hasNext()){
            Element element = (Element)it.next();
            if(element.value > value) isMax = false;
        }

        return isMax;
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
