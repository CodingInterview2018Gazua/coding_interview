#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
#include<set>
using namespace std;

int N, A[100001], C, ans;

int gcd(int x, int y) {
	return y == 0 ? x : gcd(y, x%y);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) cin >> A[i];
	
	C = A[1] - A[0];

	for (int i = 1; i < N; i++) {
		C = gcd(C, A[i] - A[i - 1]);
	}
	
	for (int i = 1; i < N; i++) {
		int k = A[i] - A[i - 1];
		if (C < k) ans += k / C - 1;
	}
	cout << ans;

}
