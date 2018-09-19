#include <string>
#include <vector>
#include<iostream>
#include<queue>
#include<set>
#include<algorithm>
#include<cstring>
#include<cstdlib>
#include<ctime>
using namespace std;
const int MAX = 10000;
int N;

int main() {
	srand((unsigned int)time(NULL));
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	N = 10;
	int* A = new int[N];
	bool* B = new bool[N];
	memset(B, false, N);
	for(int i=0; i<N; i++) {
		int k = rand() % (N * 2);
		if(B[k]) {
			i--;
			continue;
		}
		A[i] = k;
		B[k] = true;
		cout << A[i] << " ";
	}
	cout << endl;
	sort(A, A+N);
	for(int i=0; i<N; i++) {
		if(A[i] == i) {
			cout << "index : " << i << " A[i] : " << A[i] << endl;
		}
	}
}
