#include <string>
#include <vector>
#include<stack>
using namespace std;

/*
    Node = 탑의 높이, 인덱스
    heights를 순회하면서
    
    1-1. 스택이 비어있으면 현재 탑을 push한다.
    1-2-1. 비어있지 않다면 현재 탑보다 작은놈들은 모두 스택에서 뺀다.
    1-2-2-1. 그래도 스택이 비어있지 않다면 해당 스택의 top은 현재 탑보다 높이가 큰것이다.
           그래서 그 탑을 정답에 추가한다.
    1-2-2-2. 비어있다면 정답에 0을 추가한다.
    
*/

struct Node {
    int height;
    int idx;
};

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    stack<Node> st;
    for(int i=0; i<heights.size(); i++) {
        int cur = heights[i];
        if(st.empty()) {
            st.push({cur, i+1});
            answer.push_back(0);
            continue;
        }
        while(!st.empty() && st.top().height <= cur) {
            st.pop();
        }
        if(st.empty()) {
            st.push({cur, i+1});
            answer.push_back(0);    
        } else {
            answer.push_back(st.top().idx);
            st.push({cur, i+1});
        }
    }
    return answer;
}
