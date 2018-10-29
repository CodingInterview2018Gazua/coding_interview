#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

int N, A[20];

void f(int idx, vector<int>& v) {
	if (v.size() == 6) {
		for (int k : v) {
			cout << k << " ";
		}
		cout << '\n';
		return;
	}
	for (int i = idx; i < N; i++) {
		v.push_back(A[i]);
		f(i + 1, v);
		v.pop_back();
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	while (true) {
		cin >> N;
		if (!N) break;
		for (int i = 0; i < N; i++) {
			cin >> A[i];
		}
		vector<int> v;
		f(0, v);
		cout << '\n';
	}
	return 0;
}
