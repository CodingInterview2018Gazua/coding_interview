#include<iostream>
#include<string>
using namespace std;

int T, C[30];
string A, B;

void calculate(const string& s, int diff) {
	int len = s.length();
	for (int i = 0; i < len; i++) {
		C[s[i] - 'a'] += diff;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> T;
	while (T--) {
		cin >> A >> B;
		if (A.length() != B.length()) {
			cout << A << " & " << B << " are NOT anagrams." << '\n';
			continue;
		}

		calculate(A, 1);
		calculate(B, -1);

		bool isAnagram = true;
		for (int i = 0; i < 26 && isAnagram; i++) {
			if (C[i] != 0) isAnagram = false;
		}

		cout << A << " & " << B << " are " << (isAnagram ? "" : "NOT ") << "anagrams." << '\n';

	}
}