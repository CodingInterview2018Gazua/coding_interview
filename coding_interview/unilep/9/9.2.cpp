#include <string>
#include <vector>
#include<iostream>
#include<queue>
#include<set>
#include<algorithm>
#include<cstring>
using namespace std;
const int MAX = 10000;
int N, M, D[101][101];

int func(int x, int y) {
	if (!x && !y) return 1;
	if (x < 0 || y < 0) return 0;
	if (x == 0 || y == 0) return D[x][y] = 1;
	int& ret = D[x][y];
	if (ret != -1) return ret;
	ret = func(x - 1, y) + func(x, y - 1);
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	N = 3, M = 4;
	memset(D, -1, sizeof(D));
	cout << func(N, M);
}
