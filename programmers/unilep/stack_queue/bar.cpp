#include <string>
#include <vector>
#include<iostream>
using namespace std;

/*
    () 가 나올 경우 레이저를 쏘기 때문에 현재 스택사이즈 만큼 정답이 증가한다.
    ( 가 나올 경우 스택 사이즈를 증가시키고
    ) 가 나올 경우 스택 사이즈를 감소시키고 정답이 1 증가한다.
    왜냐하면 -|-  이것은 2 이기 때문
*/

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
