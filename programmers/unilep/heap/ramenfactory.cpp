#include <string>
#include <vector>
#include<queue>
using namespace std;

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    int answer = 0;
    priority_queue<int> pq;
    
    for (int i=0, j=0; i < k; i++) {
        if (dates[j] == i) {
            pq.push(supplies[j]);
            j++;
        }
        if (!stock) {
            answer++;
            stock = pq.top();
            pq.pop();
        }
        stock--;
    }
    return answer;
}
