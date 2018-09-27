#include <string>
#include <vector>

using namespace std;

// 12345
// 21232425
// 3311224455

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> A[3] = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    int C[3] = {0, };
    for(int i=0; i<answers.size(); i++) {
        for(int j=0; j<3; j++) {
            if(answers[i] == A[j][i % A[j].size()]) {
                C[j]++;
            }
        }
    }
    int mx = 0;
    for(int i=0; i < 3; i++) {
        if(mx < C[i]) mx = C[i];
    }
    for(int i=0; i<3; i++) {
        if(mx == C[i]) answer.push_back(i+1);
    }
    return answer;
}
