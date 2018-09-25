// 문제: https://programmers.co.kr/learn/courses/30/lessons/42584

#ifndef _42584_HPP_
#define _42584_HPP_

#include <string>
#include <vector>
#include <stack>

using namespace std;

namespace STACK_QUEUE_42584 {

vector<int> solution(vector<int> prices) {
	stack<pair<int, int>> s;
    vector<int> answer(prices.size(), 0);

    for (int i = 0; i < prices.size(); ++i) {
    	while (!s.empty() && s.top().second > prices[i]) {
    		pair<int, int> p = s.top();
    		s.pop();
    		answer[p.first] = i - p.first;
    	}
    	s.push(pair<int, int>(i, prices[i]));
    }
    while (!s.empty()) {
    	pair<int, int> p = s.top();
    	s.pop();
    	answer[p.first] = prices.size() - p.first - 1;
    }

    return answer;
}

}
#endif /* _42584_HPP_ */
