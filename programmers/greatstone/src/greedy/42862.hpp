#include <string>
#include <vector>
#include <list>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    sort(lost.begin(), lost.end());
    sort(reserve.begin(), reserve.end());
    
    list<int> lost_list(lost.begin(), lost.end());
    list<int> res_list(reserve.begin(), reserve.end());
    
    list<int>::iterator lost_it = lost_list.begin();
    list<int>::iterator res_it = res_list.begin();
    while (lost_it != lost_list.end() && res_it != res_list.end()) {
        if (*lost_it == *res_it) {
            lost_list.erase(lost_it++);
            res_list.erase(res_it++);
        } else if (*lost_it < *res_it) {
            ++lost_it;
        } else {
            ++res_it;
        }
    }

    lost_it = lost_list.begin();
    res_it = res_list.begin();
    int answer = n - lost_list.size();
    while (lost_it != lost_list.end() && res_it != res_list.end()) {
        if (*lost_it < *res_it - 1) {
            ++lost_it;
        } else if (*lost_it > *res_it + 1) {
            ++res_it;
        } else {
            ++lost_it;
            ++res_it;
            ++answer;
        }
    }
    return answer;
}