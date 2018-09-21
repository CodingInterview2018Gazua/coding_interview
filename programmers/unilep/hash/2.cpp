#include <string>
#include <vector>
#include<algorithm>
using namespace std;

struct trie {
	trie* c[10];
	bool finish = false;
	trie() {
		finish = false;
		for (int i = 0; i < 10; i++) c[i] = nullptr;
	}
	bool add(string str, int idx) {
		if (idx == str.length()) {
			return finish = true;
		}
		int k = str[idx] - '0';
		if (c[k] == nullptr) {
			c[k] = new trie;
		}
		if (c[k]->finish) return false;
		return c[k]->add(str, idx + 1);
	}
};

bool solution(vector<string> phone_book) {
    sort(phone_book.begin(), phone_book.end());
	trie* root = new trie;
	for (string s : phone_book) {
		if (!root->add(s, 0)) return false;
	}
	return true;
}
