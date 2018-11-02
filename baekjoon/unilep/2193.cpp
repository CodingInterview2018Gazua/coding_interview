#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
#include<queue>
#include<functional>
using namespace std;

long long N, D[101][2];

long long f(int x, int len) {
	if (len == N) {
		return 1;
	}
	long long& ret = D[len][x];
	if (ret != -1) return ret;
	ret = 0;
	if (x == 0) {
		ret += f(0, len + 1);
		ret += f(1, len + 1);
	}
	else {
		ret += f(0, len + 1);
	}
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N;
	if (1 == N) {
		cout << 1;
		return 0;
	}
	memset(D, -1, sizeof(D));
	cout << f(1, 1);
	return 0;
}
