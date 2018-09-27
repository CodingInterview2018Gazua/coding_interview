#include <string>
#include <vector>
#include<algorithm>
#include<iostream>
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for(int i=0; i<commands.size(); i++) {
        vector<int> v = array;
        int start = commands[i][0] - 1;
        int end = commands[i][1] - 1;
        int which = commands[i][2] - 1;
        sort(v.begin()+start, v.begin()+end + 1);
        answer.push_back(v[start + which]);
    }
    return answer;
}
