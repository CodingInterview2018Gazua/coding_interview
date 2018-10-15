// 문제: https://programmers.co.kr/learn/courses/30/lessons/42748
// 풀이: 문제에 주어진 대로 일부 배열 복사하고 정렬하고 해당 위치 값 

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    for (vector<int> command : commands) {
        vector<int> copy(array.begin() + command[0] - 1, array.begin() + command[1]);
        sort(copy.begin(), copy.end());
        answer.push_back(copy[command[2] - 1]);
    }
    return answer;
}
