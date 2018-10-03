#include <string>
#include <vector>
#include <queue>
#include <list>

using namespace std;

int solution(vector<int> priorities, int location) {
    list<int> q(priorities.begin(), priorities.end());
    priority_queue<int, vector<int>, less<int>> pq(priorities.begin(), priorities.end());
    
    int answer = 1;
    int pos = location;
    while (!q.empty()) {
        if (q.front() == pq.top()) {
            q.pop_front();
            pq.pop();
            if (pos == 0) {
                break;
            } else {
                --pos;   
            }
            ++answer;
        } else {
            q.push_back(q.front());
            q.pop_front();
            if (pos == 0) {
                pos = q.size() - 1;
            } else {
                --pos;
            }
        }
    }
    return answer;
}
