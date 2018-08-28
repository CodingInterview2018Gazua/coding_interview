#include<iostream>
#include<string>
using namespace std;

string A, B;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	getline(cin, A);
	cin >> B;
	for (int i = 0; i < A.length(); i++) {
		if (A[i] == ' ') continue;
		int k = B[i % B.length()] - 'a' + 1;
		A[i] = (A[i] - 'a') - k;
		if (A[i] < 0) A[i] = (A[i] + 26);
		A[i] = A[i] % 26 + 'a';
	}
	cout << A;
}
