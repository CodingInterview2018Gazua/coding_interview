#include <string>
#include <vector>
#include<iostream>
#include<stack>
using namespace std;

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
