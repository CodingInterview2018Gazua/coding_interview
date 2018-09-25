// 문제: https://programmers.co.kr/learn/courses/30/lessons/42588

#ifndef _42588_HPP_
#define _42588_HPP_

#include <string>
#include <vector>
#include <stack>

using namespace std;

namespace STACK_QUEUE_42588 {

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    stack<int> stack;
    for (int i = 0; i < heights.size(); ++i) {
    	while (!stack.empty() && heights[stack.top()] <= heights[i])
    		stack.pop();

    	if(stack.empty())
    		answer.push_back(0);
    	else
    		answer.push_back(stack.top() + 1);

    	stack.push(i);
    }
    return answer;
}

}
#endif /* _42588_HPP_ */
