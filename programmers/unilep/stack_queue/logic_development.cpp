#include <string>
#include <vector>
#include<iostream>
#include<stack>
using namespace std;

/*
    c = 배포할 개수
    
    progresses를 순회하면서
    stack에 각 작업이 몇일에 끝나는지 기록한다.
    stack의 top 보다 현재 작업이 더 늦게 끝난다면 top을 갱신하고
    그 반대면 c 를 증가한다.
*/
vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    stack<int> st;
    int c = 0;
    for(int i=0; i<progresses.size(); i++) {
        int progress = progresses[i];
        int speed = speeds[i];
        int k = (100 - progress) / speed;
        // 7 2 9
        if(st.empty()) {
            st.push(k);
            c++;
            continue;
        }
        if(st.top() < k) {
            answer.push_back(c);
            c = 1;
            st.pop();
            st.push(k);
        } else {
            c++;
        }
    }
    answer.push_back(c);
    return answer;
}
