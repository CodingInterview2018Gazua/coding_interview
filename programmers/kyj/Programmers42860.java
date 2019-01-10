import java.util.HashMap;

public class Programmers42860 {
    public static void main(String[] args){
        /**
         * description : 프로그래머스 42860번 탐욕법 > 조이스틱
         * solution : 1. 알파벳을 키로 가지고 순서를 값으로 가지는 HashMap을 만든다.
         *            2. 조이스틱의 위 아래는 26을 해당 알파벳의 순서로 나누어 2보다 크거나 같으면 위
         *            3. 작으면 아래로 움직인다고 판단한다.
         *            4. 조이스틱의 좌우 최소 움직임값은 좌, 우로 움직이는 경우를 모두 구하여 작은 경우를 더해준다.
         *            5. 좌로 움직이는 경우는, 문자의 길이가 2 이상일 때, A가 아닐 때까지 움직여서 구하고
         *            6. 우로 움직이는 경우는, A가 아닌 마지막 문자의 Index를 가져오면 된다.
         *            7. 위 + 아래의 합과 좌,우 중 작은 값을 더해 최소 움직임 수를 반환한다.
         */
//        String name = "JAZ";
//        String name = "JEROEN";
        String name = "JAN";
        System.out.println(solution(name));
    }

    public static int solution(String name) {

        char[] alpha = {'0', 'A', 'B', 'C','D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'
                , 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < alpha.length; i++){
            hm.put(alpha[i], i);
        }

        char[] nameArr = name.toCharArray();
        HashMap<Character, Integer> nameMap = new HashMap<>();
        for(int i = 0; i < nameArr.length; i++){
            nameMap.put(nameArr[i], hm.get(nameArr[i]));
        }

        int answer = 0;
        //조이스틱 위, 아래
        for (int i = 0; i < nameArr.length; i++){
            if( nameMap.get(nameArr[i]) == 1 ){
                continue;
            }

            if(26 / nameMap.get(nameArr[i]) >= 2){ //위
                answer += nameMap.get(nameArr[i]) - 1;
            }else{ //아래
                answer += 27 - nameMap.get(nameArr[i]);
            }
        }

        //조이스틱 좌, 우
        int rightMoveSum = 0;
        int leftMoveSum = 0;
        // 좌
        for (int i = nameArr.length - 1; i > 0 ; i--){
            if(i == nameArr.length - 1){
                leftMoveSum =+ 1;
                continue;
            }

            if(nameArr[i] != 'A'){
                leftMoveSum =+ nameArr.length - i;
            }
        }
        // 우
        for (int i = nameArr.length - 1; i > 0 ; i--){
            if(nameArr[i] != 'A'){
                rightMoveSum = i;
                break;
            }
        }

//        System.out.println("answer = " + answer);
//        System.out.println("leftMoveSum = " + leftMoveSum);
//        System.out.println("rightMoveSum = " + rightMoveSum);

        return (leftMoveSum > rightMoveSum) ? answer + rightMoveSum : answer + leftMoveSum;
    }
}
