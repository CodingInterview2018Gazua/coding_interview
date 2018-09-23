#include <string>
#include <vector>
#include<stack>
using namespace std;

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
