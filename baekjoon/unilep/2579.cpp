#include <iostream>
#include<cstring>
#include<algorithm>
using namespace std;
int N, A[301], D[301];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N;
	for(int i=1; i<=N; i++) {
		cin >> A[i];
	}
	D[1] = A[1];
	if(N >= 2) D[2] = A[1] + A[2];
	if(N >= 3) D[3] = max(A[1], A[2]) + A[3];
	for(int i=4; i<=N; i++) {
		D[i] = D[i-3] + A[i-1] + A[i];
		D[i] = max(D[i], D[i-2] + A[i]);
	}
	cout << D[N];
    return 0;
}
