#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    priority_queue<int,vector<int>,greater<int> > pq(scoville.begin(), scoville.end());
    for (int mix_count = 1; mix_count < scoville.size(); ++mix_count) {
        int first = pq.top();
        pq.pop();
        int second = pq.top();
        pq.pop();
        pq.push(first + second * 2);
        if (pq.top() >= K) {
            return mix_count;
        }
    }
    return -1;
}
