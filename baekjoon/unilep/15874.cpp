#include<iostream>
#include<string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int K, S, T;
	cin >> K;
	cin >> S;
	string s;
	K %= 26;
	getline(cin, s);
	getline(cin, s);
	for(int i=0; i<S; i++) {
		if(s[i] >= 'A' && s[i] <= 'Z') {
			s[i] = (s[i] - 'A' + K) % 26 + 'A';
		}
		else if(s[i] >= 'a' && s[i] <= 'z') {
			s[i] = (s[i] - 'a' + K) % 26 + 'a';
		}
	}	
	cout << s;
}
