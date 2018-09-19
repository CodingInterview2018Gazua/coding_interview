#include <string>
#include <vector>
#include<iostream>
#include<queue>
#include<set>
#include<algorithm>
#include<cstring>
using namespace std;

int T, N, A[21], M, D[10001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> T;
	while(T--) {
		memset(D, 0, sizeof(D));
		cin >> N;
		for(int i=0; i<N; i++) cin >> A[i];
		cin >> M;
		D[0] = 1;
		for(int i=0; i<N; i++) {
			for(int j=A[i]; j<=M; j++) {
				D[j] += D[j - A[i]];
			}
		}
		cout << D[M] << '\n';
	}
}
