#include <string>
#include <vector>
#include<iostream>
#include<queue>
#include<set>
#include<algorithm>
#include<cstring>
using namespace std;

vector<int> v;
void func(int idx, vector<int>& A) {
	if(idx == v.size()) {
		return;
	}
	for(int k : A) {
		cout << k << " ";
	}
	cout << endl;
	for(int i=idx; i<v.size(); i++) {
		A.push_back(v[i]);
		func(i+1, A);
		A.pop_back();
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int N = 4;
	v.resize(N);
	for(int i=0; i<N; i++) {
		v[i] = i+1;
	}
	vector<int> A;
	func(0, A);
}
