#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace std;

int N, S, A[20001], ans;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N >> S;
	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
	sort(A, A + N);
	for (int i = 0; i < N; i++) {
		int k = S - A[i];
		int lo = 0;
		int hi = N - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (A[mid] <= k) {
				lo = mid + 1;
			}
			else {
				hi = mid - 1;
			}
		}
		if (lo > i) {
			ans += lo - i - 1;
		}
		else {
			break;
		}
	}
	cout << ans;
}
// 1 2 3 5
// 5 4 3 1
