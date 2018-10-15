// 문제: https://programmers.co.kr/learn/courses/30/lessons/42747
// 풀이: 주어진 citations를 오름차순으로 정렬한 뒤, 루프를 돌면서 h를 계산하여 조건에 부합되면 리턴
//      Note. 정렬되었으므로 루프 중 어떤 항목이 h값 이상이라는 것은 그 이후의 모든 항목이 h값 이상이라는 것을 

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end());
    for (int i = 0; i < citations.size(); ++i) {
        if (citations[i] >= citations.size() - i) {
            return citations.size() - i;
        }
    }
    return 0;
}
