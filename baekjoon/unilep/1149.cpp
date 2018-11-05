#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
#include<queue>
#include<functional>
using namespace std;

int N, A[1001][3], D[1001][3];


int f(int x, int y) {
	if (x == N - 1) {
		if (y == 0) {
			return min(A[x][1], A[x][2]);
		}
		else if(y==1){
			return min(A[x][0], A[x][2]);
		}
		else {
			return min(A[x][0], A[x][1]);
		}
	}
	int& ret = D[x][y];
	if (ret != -1) return ret;
	ret = 987654321;
	if (y == 0) {
		ret = min(ret, f(x + 1, 1) + A[x][1]);
		ret = min(ret, f(x + 1, 2) + A[x][2]);
	}
	else if (y == 1) {
		ret = min(ret, f(x + 1, 0) + A[x][0]);
		ret = min(ret, f(x + 1, 2) + A[x][2]);
	}
	else {
		ret = min(ret, f(x + 1, 0) + A[x][0]);
		ret = min(ret, f(x + 1, 1) + A[x][1]);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N;
	memset(D, -1, sizeof(D));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> A[i][j];
		}
	}
	cout << min({ f(0, 0), f(0,1), f(0,2) });
	return 0;
}
