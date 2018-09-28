// 문제: https://programmers.co.kr/learn/courses/30/lessons/42584

#ifndef _42585_HPP_
#define _42585_HPP_

#include <string>
#include <vector>
#include <stack>

using namespace std;

namespace STACK_QUEUE_42585 {

int solution(string arrangement) {
	char prev = 0;
	stack<char> s;
    int answer = 0;
	for (char c : arrangement) {
		if (c == '(') {
			s.push(c);
		} else if (c == ')'){
			s.pop();
			if (prev == '(') {
				answer += s.size();
			} else {
				++answer;
			}
		}
		prev = c;
	}
    return answer;
}

}
#endif /* _42585_HPP_ */
