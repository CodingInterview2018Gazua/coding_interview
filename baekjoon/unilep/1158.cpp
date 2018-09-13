#include<iostream>
#include<queue>
using namespace std;

int N, M;
deque<int> dq;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		dq.push_back(i);
	}
	cout << "<";
	while (dq.size() != 1) {
		for (int i = 1; i < M; i++) {
			int k = dq.front();
			dq.pop_front();
			dq.push_back(k);
		}
		cout << dq.front() << (dq.size() == 1 ? "" : ", ");
		dq.pop_front();
	}
	cout << dq.front() << ">";
}
