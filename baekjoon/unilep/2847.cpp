#include <iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<queue>
using namespace std;
int N, A[101], ans;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N;
	for(int i=0; i<N; i++) {
		cin >> A[i];
	}
	for(int i=N-1; i>0; i--) {
		if(A[i] <= A[i-1]) {
			ans += A[i-1] - A[i] + 1;
			A[i-1] = A[i] - 1;
		}
	}
	cout << ans;
    return 0;
}
