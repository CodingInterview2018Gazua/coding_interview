#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
using namespace std;
int N, M;
char A[21][21];

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

int f(int x, int y, int status) {
	int ret = 1;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
		int k = 1 << (A[nx][ny] - 'A');
		if (status & k) {
			continue;
			
		}
		ret = max(ret, f(nx, ny, status | k) + 1);
	}
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> A[i][j];
		}
	}
	cout << f(0, 0, 1 << (A[0][0] - 'A'));
}
