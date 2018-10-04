// 문제: https://programmers.co.kr/learn/courses/30/lessons/42626
// 풀이: 작은 값을 먼저 출력하는 우선 순위 큐에 넣고 작은 값 두개를 꺼내어 스코빌 지수를 계산하여 큐에 넣는 작업을 반복
//       큐의 아이템이 2개 미만이 되거나 가장 작은 값이 K 이상이 되면 종료

#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    priority_queue<int,vector<int>,greater<int> > pq(scoville.begin(), scoville.end());
    int answer = 0;
    while (pq.size() >= 2 && pq.top() < K) {
        int first = pq.top();
        pq.pop();
        int second = pq.top();
        pq.pop();
        pq.push(first + second * 2);
        ++answer;
    }
    if (pq.top() >= K) 
        return answer;
    else
        return -1;
}
