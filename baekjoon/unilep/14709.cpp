#include<iostream>
#include<vector>
#include<functional>
#include<queue>
#include<string>
using namespace std;

int N, X, Y;
bool P[6][6];

// 엄지 약지 중지 1 3 4
// 검지 새끼 2 5

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> X >> Y;
		P[X][Y] = P[Y][X] = true;
	}
	if (N != 3) {
		cout << "Woof-meow-tweet-squeek";
		return 0;
	}
	if (P[1][3] && P[1][4] && P[3][4]) {
		bool no = false;
		for (int i = 1; i <= 5 && !no; i++) {
			if (P[2][i]) no = true;
		}
		for (int i = 1; i <= 5 && !no; i++) {
			if (P[5][i]) no = true;
		}
		if (!no) {
			cout << "Wa-pa-pa-pa-pa-pa-pow!";
			return 0;
		}
	}
	cout << "Woof-meow-tweet-squeek";
	
}
