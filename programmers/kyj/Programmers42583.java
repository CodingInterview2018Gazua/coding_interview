import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yong on 2018. 10. 6..
 */
public class Programmers42583 {
    public static void main(String[] args) throws IOException{
        /**
         * @description : 프로그래머스 42583번 스택/큐 다리를 지나는 트럭
         * @solution : 1. 다리를 지나기 전 대기 큐, 다리를 지날 때 저장 큐, 다리를 지나고 나서 저장 큐. 총 3개의 큐를 만든다.
         *             2. 다리를 지나는 큐는 1초에 1만큼 이동하는 정보도 저장하고 있어야 하기 때문에 Class로 만든다.
         *             3. 다리에 올라갈 수 있는 무게와 트럭 수를 조건으로 세어주면서 소요되는 시간을 게산한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bridge_length = Integer.parseInt(br.readLine());
        int weight = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().trim().split(" ");
        int[] truck_weights = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int answer = solution(bridge_length, weight, truck_weights);
        System.out.print(answer);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> watingTruckQueue = new LinkedList<>();
        int truckWeightsLength = truck_weights.length;
        for(int i = 0; i < truckWeightsLength; i++){
            watingTruckQueue.offer(truck_weights[i]);
        }

        Queue<Truck> inBridgeTruckQueue = new LinkedList<>();
        Queue<Integer> passedTruckQueue = new LinkedList<>();
        int time = 0;
        int weightSum = 0;
        int w1, w2, m2;
        while(true) {
            if (!watingTruckQueue.isEmpty()) {
                w1 = watingTruckQueue.peek();
                time++;

                if (!inBridgeTruckQueue.isEmpty()) {
                    w2 = inBridgeTruckQueue.peek().weight;
                    m2 = inBridgeTruckQueue.peek().move;

                    if (m2 == bridge_length) {
                        weightSum -= w2;
                        passedTruckQueue.offer(inBridgeTruckQueue.poll().weight);
                    }

                    if (weight - (weightSum) >= w1 && inBridgeTruckQueue.size() < bridge_length) {
                        w1 = watingTruckQueue.poll();
                        weightSum += w1;
                        inBridgeTruckQueue.offer(new Truck(w1, 0));
                    }

                } else {
                    weightSum += w1;
                    inBridgeTruckQueue.offer(new Truck(watingTruckQueue.poll(), 0));
                }

                updateInBridgeTruckTime(inBridgeTruckQueue);

            } else if (!inBridgeTruckQueue.isEmpty() && bridge_length > 1){
                time++;
                m2 = inBridgeTruckQueue.peek().move;

                if (m2 == bridge_length) {
                    passedTruckQueue.offer(inBridgeTruckQueue.poll().weight);
                }

                updateInBridgeTruckTime(inBridgeTruckQueue);

            } else {
                break;
            }
        }

        return time;
    }

    static void updateInBridgeTruckTime(Queue inBridgeTruckQueue){
        Iterator<Truck> it = inBridgeTruckQueue.iterator();
        while(it.hasNext()){
            Truck truck = (Truck)it.next();
            truck.move++;
        }
    }
}

class Truck{
    int weight;
    int move;

    Truck(int weight, int move){
        this.weight = weight;
        this.move   = move;
    }
}