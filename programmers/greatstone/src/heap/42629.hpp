// 문제: https://programmers.co.kr/learn/courses/30/lessons/42629
// 풀이: 공급량이 큰 항목을 먼저 출력하는 우선 순위 큐를 사용한다.
//       현재 가지고 있는 밀가루(stock)로 버틸 수 있는 기간 동안의 공급 중 가장 공급량이 큰 항목을 선택해나가다가
//       stock이 k 이상이 되면 종료한다.

#include <string>
#include <vector>
#include <queue>

using namespace std;

struct Supply {
    int date;
    int amount;
    
    Supply(int _date, int _amount): date(_date), amount(_amount) {}
    
    bool operator <(const Supply& that) const{
        return amount < that.amount;
    }
};

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    priority_queue<Supply> pq;
    int answer = 0;
    int supply_index = 0;
    while (stock < k) {
        while (dates[supply_index] <= stock) {
            pq.push(Supply(dates[supply_index], supplies[supply_index]));
            ++supply_index;
        }
        stock += pq.top().amount;
        pq.pop();
        ++answer;
    }
    return answer;
}
