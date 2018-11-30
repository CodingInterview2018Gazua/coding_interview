#include<iostream>
#include<cstring>
#include<algorithm>
#include<queue>
using namespace std;

int n, time, pre;

vector<int> a[501];
int b[501], ind[501], ans[501];
queue<int> q;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> time;
		b[i] = time;
		while (true) {
			cin >> pre;
			if (pre == -1) break;
			a[pre].push_back(i);
			ind[i]++;
		}
	}
	for (int i = 1; i <= n; i++) if (ind[i] == 0) {
		q.push(i);
		ans[i] = b[i];
	}
	while (!q.empty()) {
		int no = q.front();
		q.pop();
		for (int i = 0; i < a[no].size(); i++) {
			int next = a[no][i];
			ind[next]--;
			ans[next] = max(ans[next], ans[no] + b[next]);
			if(ind[next] == 0) q.push(next);
		}
	}
	for (int i = 1; i <= n; i++) cout << ans[i] << '\n';
	return 0;
}
