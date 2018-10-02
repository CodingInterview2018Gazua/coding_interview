#include <string>
#include <vector>
#include <queue>

using namespace std;

int g_remain;

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
