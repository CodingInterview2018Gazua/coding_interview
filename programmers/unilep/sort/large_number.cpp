#include <string>
#include <vector>
#include<iostream>
#include<algorithm>
using namespace std;

struct oper {
    bool operator() (string a, string b) {
        int p = stoi(a + b);
        int q = stoi(b + a);
        return p > q;
    }
};
string solution(vector<int> numbers) {
    string answer = "";
    vector<string> v;
    for(int i=0; i<numbers.size(); i++) {
        v.push_back(to_string(numbers[i]));
    }
    sort(v.begin(), v.end(), oper());
    for(int i=0; i<v.size(); i++) {
        answer += v[i];
    }
    bool find = false;
    int del = 0;
    for(int i=0; i<answer.length() && !find; i++) {
        if(answer[i] == '0') {
            del++;
        } else {
            find = true;
        }
    }
    if(del) {
        answer = answer.substr(del - 1, answer.length());
    }
    return answer;
}
