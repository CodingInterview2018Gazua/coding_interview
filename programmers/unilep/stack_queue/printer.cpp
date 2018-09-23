#include <string>
#include <vector>
#include<queue>
#include<iostream>
using namespace std;

struct Node {
    int priority;
    int idx;
};

int solution(vector<int> priorities, int location) {
    int answer = 0;
    deque<Node> dq;
    for(int i=0; i<priorities.size(); i++) {
        dq.push_back({priorities[i], i});   
    }
    bool printed[101] = {false, };
    while(!dq.empty()) {
        Node node = dq.front();
        bool is = true;
        
        for(int i=0; i<priorities.size() && is; i++) {
            if(node.idx == i || printed[i]) continue;
            int next = priorities[i];
            if(node.priority < next) {
                dq.pop_front();
                dq.push_back(node);
                is = false;
            }
        }
        if(is) {
            answer++;
            printed[node.idx] = true;
            dq.pop_front();
            if(node.idx == location) {
                return answer;
            }
            
        }
    }
    return answer;
}
