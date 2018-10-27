#include <iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int N, M;
char A[1001][1001];
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
bool visit[1001][1001];

bool dfs(int x, int y) {
	visit[x][y] = true;
	if(x == N-1) {
		return true;
	}
	bool end = false;
	for(int i=0; i<4 && !end; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
		if(visit[nx][ny] || A[nx][ny] == '1') continue;
		end |= dfs(nx, ny);
	}
	return end;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N >> M;
	for(int i=0; i<N; i++) {
		for(int j=0; j<M; j++) {
			cin >> A[i][j];
		}
	}
	for(int i=0; i<M; i++) {
		if(A[0][i] == '0' && dfs(0, i)) {
			cout << "YES";
			return 0;
		}
	}
	cout << "NO";
}
