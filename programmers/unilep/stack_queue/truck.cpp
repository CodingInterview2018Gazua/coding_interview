#include <string>
#include <vector>
#include<queue>
#include<iostream>
using namespace std;

/*
    answer = 경과 시간
    on_weight = 다리에 있는 트럭의 무게 총합
    queue<Node> q = 다리에 있는 트럭의 정보(몇초, 무게)
    
    vector<int> truck_weights를 순회하면서
    on_weight + k(현재 트럭무게) 가 weight(제한) 이하라면 --> (현재 트럭이 다리에 올 수 있다.)
    on_weight를 k만큼 증가시킨다.
    q에 현재 트럭을 넣는다.
    
    현재 시간 - 큐에 처음에 있는 트럭의 시간 + 1 == 다리길이 인 경우
    큐에 처음에 있는 트럭은 다리를 건넌 것이다. on_weight를 감소해주고
    큐에서 뺀다.
    
    마지막에 q에 남이있는 트럭이 있을 수 있으므로
    다리를 다 건널때까지 똑같이 계산한다.
    
*/

struct Node {
    int pos;
    int weight;
};

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int on_weight = 0;
    queue<Node> q;
    for(int i=0; i<truck_weights.size(); i++) {
        answer++;
        int k = truck_weights[i];    
        if(on_weight + k <= weight) {
            on_weight += k;
            q.push({answer, k});
        } else {
            i--;
        }
        if(answer - q.front().pos + 1 == bridge_length) {
            on_weight -= q.front().weight;
            q.pop();
        }    
    }
    while(!q.empty()) {
        if(answer - q.front().pos == bridge_length) {
            q.pop();
        }
        answer++;
    }
    return answer - 1;
}
