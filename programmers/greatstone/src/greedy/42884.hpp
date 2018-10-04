// 문제: https://programmers.co.kr/learn/courses/30/lessons/42884
// 풀이: 최소의 카메라 수를 구하기 위해 카메라가 꼭 필요한 가장 늦은 위치를 찾아간다.
//       한번도 카메라를 만나지 않은 차가 진출하는 위치가 카메라가 꼭 필요한 가장 늦은 위치가 된다.
//       진출 순서로 정렬된 차를 큐에 넣고, 가장 먼저 진출하는 차의 진출 위치에 카메라를 설치하고
//       큐에서 카메라를 만나는 차를 모두 제거한다.
//       Note: 카메라를 만나는 차를 큐에서 제거할 때, 카메라를 만나지만 큐의 뒷부분에 있어 제거되지 않는 차가 있을 수 있다.
//             하지만 이 차도 다음 카메라에서 제거되므로 고려할 필요가 없다.

#include <string>
#include <vector>
#include <list>
#include <algorithm>

using namespace std;

bool compare(const vector<int>& left, const vector<int>& right) {
    return left[1] < right[1];
}

int solution(vector<vector<int>> routes) {
    sort(routes.begin(), routes.end(), compare);
    list<vector<int>> l(routes.begin(), routes.end());
    int answer = 0;
    while (!l.empty()) {
        int camera = l.front()[1];
        do {
            l.pop_front();
        } while(!l.empty() && l.front()[0] <= camera && camera <= l.front()[1]);
        ++answer;
    }
    return answer;
}
