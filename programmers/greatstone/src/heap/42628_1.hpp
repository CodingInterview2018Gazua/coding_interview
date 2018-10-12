// 문제: https://programmers.co.kr/learn/courses/30/lessons/42628
// 풀이: C++ STL의 multiset을 사용. multiset은 순서가 보장되는 iterator를 제공함.

#include <string>
#include <vector>
#include <set>

using namespace std;

vector<int> solution(vector<string> operations) {
    multiset<int> ms;
    for (string operation : operations) {
        char command;
        int number;
        sscanf(operation.c_str(), "%c %d", &command, &number);
        if (command == 'I') {
            ms.insert(number);
        } else if (command == 'D' && !ms.empty()) {
            if (number == 1) {
                ms.erase(--ms.end());
            } else if (number == -1) {
                ms.erase(ms.begin());
            }
        }
    }
    vector<int> answer;
    if (ms.empty()) {
        answer.push_back(0);
        answer.push_back(0);
    } else {
        answer.push_back(*(--ms.end()));
        answer.push_back(*ms.begin());
    }
    return answer;
}
