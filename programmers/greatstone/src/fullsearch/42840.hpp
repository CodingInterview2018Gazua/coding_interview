#include <string>
#include <vector>
#include <iostream>

using namespace std;

int grade(vector<int>& answers, vector<int>& supo) {
    vector<int>::iterator it = supo.begin();
    int grade = 0;
    for (int answer : answers) {
        if (*it == answer) {
            ++grade;
        }
        ++it;
        if (it == supo.end()) {
            it = supo.begin();
        }
    }
    cout << grade << endl;
    return grade;
}

vector<int> solution(vector<int> answers) {
    vector<int> supo1{1, 2, 3, 4, 5};
    vector<int> supo2{2, 1, 2, 3, 2, 4, 2, 5};
    vector<int> supo3{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    int supo1_grade = grade(answers, supo1);
    int supo2_grade = grade(answers, supo2);
    int supo3_grade = grade(answers, supo3);
    
    vector<int> answer;
    if (supo1_grade >= supo2_grade && supo1_grade >= supo3_grade) {
        answer.push_back(1);
    }
    if (supo2_grade >= supo1_grade && supo2_grade >= supo3_grade) {
        answer.push_back(2);
    }
    if (supo3_grade >= supo1_grade && supo3_grade >= supo2_grade) {
        answer.push_back(3);
    }
    return answer;
}