#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
#include<queue>
#include<functional>
using namespace std;

int X;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> X;
	int ans = 0;
	while (X) {
		if (X & 1) ans++;
		X /= 2;
	}
	cout << ans;
	return 0;
}
