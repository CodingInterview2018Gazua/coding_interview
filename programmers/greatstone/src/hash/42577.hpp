// 문제: https://programmers.co.kr/learn/courses/30/lessons/42577

#ifndef _42577_HPP_
#define _42577_HPP_

#include <string>
#include <vector>
#include <map>

using namespace std;

namespace HASH_42577 {

class Trie {
	map<char, Trie*> children;
	bool end = false;

public:
	~Trie() {
		for(auto it = children.begin(); it != children.end(); ++it )
			delete it->second;
	}

	void insert(const char* key) {
		if (*key != 0) {
			auto child = children.find(*key);
			if (child == children.end())
				children[*key] = new Trie();
			children[*key]->insert(key + 1);
		} else {
			end = true;
		}
	}

	bool find(const char* key) {
		if (*key == 0 || end) return true;
		auto child = children.find(*key);
		if (child == children.end())
			return false;
		return child->second->find(key + 1);
	}
};

bool solution(vector<string> phone_book) {
	Trie trie;
	for (string s : phone_book) {
		if (trie.find(s.c_str()))
			return false;
		else
			trie.insert(s.c_str());
	}
    return true;
}

}
#endif /* _42577_HPP_ */
