#include <string>
#include <vector>
#include<queue>
#include<iostream>
#include<functional>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq; 
    for(int k : scoville) {
        pq.push(k);
    }
    while(!pq.empty()) {
        int k = pq.top();
        if(k >= K) break;
        pq.pop();
        if(!pq.empty()) {
            int q = pq.top();
            pq.pop();
            pq.push(k + (q * 2));
            answer++;
        } else {
            return -1;
        }
    }
    return answer;
}
