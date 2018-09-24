/**
 * Created by yong on 2018. 9. 24..
 */
public class Programmers42588 {
    public static void main(String[] args){
        /**
         * description : 프로그래머스 42588번 스택/큐, 탑
         * solution    : 1. 두 개의 for문을 작성한다.
         *               2. 첫번째 for문은 첫 번째 원소를 제외한 배열의 길이만큼
         *               3. 두번째 for문은 왼쪽으로 이동하면서 자신 보다 큰 원소를 만나면 break 한다
         */
//        int[] heights = {6, 9, 5, 7, 4};
//        int[] heights = {3, 9, 9, 3, 5, 7, 2};
        int[] heights = {1, 5, 3, 6, 7, 6 ,5};

        int heightsLength = heights.length;
        int [] answer = new int[heightsLength];
        for(int i = 1; i < heightsLength; i++){
            int index = 0;
            int tmp = heights[i];
            for(int j = i - 1; j >= 0; j--){
                if(tmp < heights[j]){
                    index = j + 1;
                    break;
                }
            }
            answer[i] = index;
        }
    }
}
