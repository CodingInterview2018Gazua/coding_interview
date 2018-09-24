#include <string>
#include <vector>
#include<iostream>
using namespace std;

int solution(string arrangement) {
    int answer = 0;
    int stack = 0;
    for(int i=0; i<arrangement.length() - 1; i++) {
        char c = arrangement[i];
        if(c == '(' && arrangement[i+1] == ')') {
            answer += stack;
            i++;
            continue;
        }
        if(c == '(') {
            stack++;
        } else {
            stack--;
            answer += 1;
        }
    }
    return answer + stack;
}
