// 문제: https://programmers.co.kr/learn/courses/30/lessons/42746
// 풀이: 두 정수를 이어 붙였을 때 더 큰 수를 만들 수 있는 순서로 정렬한 후 모두 합쳐 반환한다.
//      두 정수의 순서는 두 정수를 문자열로 보고 n1 + n2로 붙인 경우와 n2 + n1으로 붙인 경우를 비교하여 결정한다.
//      예를 들어, 3과 30이 있다면 330과 303을 비교한다. 330이 더 크므로 3이 더 크다고 판단한다.

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(const string& left, const string& right) {
    return left + right > right + left;
}

string solution(vector<int> numbers) {
    vector<string> s_numbers;
    for (int number : numbers) {
        s_numbers.push_back(to_string(number));
    }
    sort(s_numbers.begin(), s_numbers.end(), compare);
    string answer = "";
    for (string number : s_numbers) {
        answer += number;
    }
    if (answer[0] == '0') {
        answer = "0";
    }
    return answer;
}
