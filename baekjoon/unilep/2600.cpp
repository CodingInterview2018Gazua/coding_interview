#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
using namespace std;

int b1, b2, b3, k1, k2, D[501][501];

int f(int x, int y) {
	int& ret = D[x][y];
	if (ret != -1) return ret;

	int val = 1;
	if (x - b1 >= 0) ret = f(x - b1, y);
	if (ret == 1) val = 0;
	if (x - b2 >= 0) ret = f(x - b2, y);
	if (ret == 1) val = 0;
	if (x - b3 >= 0) ret = f(x - b3, y);
	if (ret == 1) val = 0;
	if (y - b1 >= 0) ret = f(x, y - b1);
	if (ret == 1) val = 0;
	if (y - b2 >= 0) ret = f(x, y - b2);
	if (ret == 1) val = 0;
	if (y - b3 >= 0) ret = f(x, y - b3);
	if (ret == 1) val = 0;
	return ret = val;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> b1 >> b2 >> b3;
	for (int i = 0; i < 5; i++) {
		memset(D, -1, sizeof(D));
		cin >> k1 >> k2;
		cout << (f(k1, k2) == 0 ? 'A' : 'B') << '\n';
	}
	return 0;
}
