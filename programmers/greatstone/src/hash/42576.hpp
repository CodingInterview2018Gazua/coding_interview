// 문제: https://programmers.co.kr/learn/courses/30/lessons/42576

#include <string>
#include <vector>
#include <set>

using namespace std;

namespace HASH_42576 {

string solution(vector<string> participant, vector<string> completion) {
	multiset<string> mset(completion.begin(), completion.end());
	for (string s : participant) {
		multiset<string>::iterator it = mset.find(s);
		if (it != mset.end()) {
			mset.erase(it);
		} else {
			return s;
		}
	}
	return "";
}

}
