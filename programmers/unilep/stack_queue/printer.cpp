#include <string>
#include <vector>
#include<queue>
#include<iostream>
using namespace std;

/* 
    해당 문서의 번호, 우선순위를 원소로 가지는 deque 생성
    vector<int> priorities 를 모두 꺼내어 deque에 넣는다.
    
    dq가 비어있을때까지(모든 문서가 출력될때까지)
    아래 로직을 반복한다.
    
    1. dq에서 node 하나를 꺼낸다. (node는 해당 문서의 우선순위와 인덱스)
    2. 꺼낸 node가 모든 문서중 우선순위가 가장 높은지 확인한다 (for문)
    3-1. 꺼낸 node가 우선순위가 가장 높다면 
         printed[node.ix] = true를 해주어 다음에 또 인쇄할일 없게 해준다.
         몇번째로 인쇄되었는지 확인하기위해 answer++;
         dq에서 제거한다.
         그리고 현재 문서의 인덱스가 찾고자하는 문서인 경우 (node.idx == location)
         answer를 리턴한다.
    3-2. 꺼낸 node보다 우선순위가 높은 문서가 있다면
         꺼낸 node를 맨뒤에 넣는다.
    
    # 꺼낸 node라고 표현했지만 사실 deque의 맨 앞에 있는 node를 의미함
*/

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
