#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

int M, N;
int a[1001][1001];
int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { 1, -1, 0, 0 };
int c = 0;
int d = 0;
int no = 0;
int tot = 0;
queue<pair<int, int> > q;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> M >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> a[i][j];
			if (a[i][j] == 1) {
				q.push({i, j});
			}
			else if (a[i][j] == 0) {
				tot++;
			}
		}
	}
	while (!q.empty()) {
		pair<int, int> p = q.front();
		q.pop();
		int i = p.first;
		int j = p.second;
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && a[nx][ny] == 0) {	
				if (a[nx][ny] == 0) {
					a[nx][ny] = a[i][j] + 1;
					q.push({nx, ny});
					tot--;
				}
				d = a[nx][ny] - 1;
			}
		}
	}
	if(tot == 0)
		cout << d << endl;
	else cout << -1 << endl;

	return 0;
}
