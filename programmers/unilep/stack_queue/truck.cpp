#include <string>
#include <vector>
#include<queue>
#include<iostream>
using namespace std;

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
