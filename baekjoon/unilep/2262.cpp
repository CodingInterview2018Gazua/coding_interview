#include<iostream>
#include<queue>
using namespace std;
const int MAX = 100001;
int N, A[MAX], B[MAX], C[MAX], K = 5;

void f(int s, int e, int ss, int se) {
	if (s > e || ss > se) return;
	int k = B[se]; // 4
	cout << k << " ";
	int inorderIdx = C[k];
	int rightIdx = inorderIdx - s; // 3
	f(s, inorderIdx - 1, ss, ss + rightIdx - 1);
	f(inorderIdx + 1, e, ss + rightIdx, se - 1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> A[i];
		C[A[i]] = i;
	}
	for (int i = 1; i <= N; i++) cin >> B[i];
	f(1, N, 1, N);
}
