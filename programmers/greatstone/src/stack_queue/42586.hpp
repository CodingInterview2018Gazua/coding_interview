//문제: https://programmers.co.kr/learn/courses/30/lessons/42586

#ifndef _42586_HPP_
#define _42586_HPP_

#include <string>
#include <vector>
#include <list>
#include <cmath>

using namespace std;

namespace STACK_QUEUE_42586 {

vector<int> solution(vector<int> progresses, vector<int> speeds) {
	list<int> q;
	for (int i = 0; i < progresses.size(); ++i) {
		int remains = ceil((100.0 - progresses[i]) / speeds[i]);
		q.push_back(remains);
	}
    vector<int> answer;
    int next_release = q.front();
    int features = 1;
    q.pop_front();
    while (!q.empty()) {
    	if (next_release < q.front()) {
    		answer.push_back(features);
    		next_release = q.front();
    		features = 1;
    	} else {
    		++features;
    	}
    	q.pop_front();
    }
    answer.push_back(features);
    return answer;
}

}

#endif /* _42586_HPP_ */
