// 문제: https://programmers.co.kr/learn/courses/30/lessons/42883
// 풀이: 순차적으로 루프를 돌며 제거 대상인지 확인하는 방법으로 문제를 해결한다.
//       제거 대상인지 확인하는 방법은 k+1개의 숫자를 한 그룹으로 묶었을 때, 
//       그 그룹에서 가장 큰 수 앞에 있는 숫자는 모두 제거하는 것이다.
//       코드는 K+1개의 숫자를 한 그룹으로 묶어 그 중 가장 큰 수를 선택하여 answer에 추가하는 방식으로 구현했다.

#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int cur_index = 0;
    while (k > 0) {
        char max = 0;
        int max_index = 0;
        for (int i = cur_index; i < cur_index + k + 1; ++i) {
            if (max < number[i]) {
                max = number[i];
                max_index = i;
            }
        }
        answer += max;
        k -= (max_index - cur_index);
        cur_index = max_index + 1;
        if (k + cur_index == number.size()) {
            cur_index = number.size();
            break;
        }
    }
    answer += number.substr(cur_index);
    return answer;
}
