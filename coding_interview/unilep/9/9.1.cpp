#include <string>
#include <vector>
#include<iostream>
#include<queue>
#include<set>
#include<algorithm>
#include<cstring>
using namespace std;
const int MAX = 10000;
int N, D[MAX];

int func(int x) {
	if (x < 0) return 0;
	if (!x) return 1;
	
	int& ret = D[x];
	if (ret != -1) return ret;

	ret = func(x - 1) + func(x - 2) + func(x - 3);
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	N = 11;
	memset(D, -1, sizeof(D));
	cout << func(N);
}
