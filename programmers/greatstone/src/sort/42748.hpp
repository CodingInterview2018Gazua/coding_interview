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
