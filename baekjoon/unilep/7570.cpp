#include<iostream>
#include<vector>
#include<functional>
#include<queue>
#include<string>
using namespace std;

int N, A[1000001], D[1000001], ans = 987654321;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> A[i];
	}
	for (int i = 1; i <= N; i++) {
		D[A[i]] = D[A[i] - 1] + 1;
	}
	for (int i = 1; i <= N; i++) {
		ans = min(ans, N - D[i]);
	}
	cout << ans;
	
}
