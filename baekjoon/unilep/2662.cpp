#include <string>
#include <vector>
#include<iostream>
#include<queue>
#include<set>
#include<algorithm>
#include<cstring>
using namespace std;
const int INF = 987654321;
int N, M, A[21][301], D[21][301], K, C[21][301];

int func(int company, int money) {
	if (company > M) return 0;
	
	int& ret = D[company][money];
	if (ret != -1) return ret;
	ret = 0;
	
	for (int i = 0; i <= money; i++) {
		int k = func(company + 1, money - i) + A[company][i];
		if (ret < k) {
			ret = k;
			C[company][money] = i;
		}
	}
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		cin >> K;
		for (int j = 1; j <= M; j++) {
			cin >> A[j][K];
		}
	}
	memset(D, -1, sizeof(D));
	cout << func(1, N) << '\n';
	for (int i = 1; i <= M; i++) {
		cout << C[i][N] << " ";
		N -= C[i][N];
	}
}
