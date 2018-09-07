#include<iostream>
#include<string>
#include<queue>
#include<stack>
using namespace std;
const int INF = 987654321;
int N, K, A, B, P[1001], Q[1001];
vector<int> V[1001];
string s[1001];

bool hamming_code(string a, string b) {
	int dist = 0;
    for (unsigned int i = 0; i < a.length(); ++i) {
        if (a[i] != b[i]) {
            ++dist;
        }
    }
    return dist == 1;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N >> K;
	for (int i = 1; i <= N; i++) {
		cin >> s[i];
		P[i] = -1;
	}
	for (int i = 1; i <= N; i++){
		for (int j = i + 1; j <= N; j++) {
			if (hamming_code(s[i], s[j])) {
				V[i].push_back(j);
				V[j].push_back(i);
			}
		}
	}
	cin >> A >> B;
	queue<int> q;
	q.push(A);
	while (!q.empty()) {
		int no = q.front(); q.pop();
		for (int next : V[no]) {
			if (P[next] != -1) continue;
			q.push(next);
			P[next] = no;
		}
	}
	if (P[B] == -1) {
		cout << -1;
		return 0;
	}
	stack<int> st;
	while (B != A) {
		st.push(B);
		B = P[B];
	}
	st.push(A);
	while (!st.empty()) { cout << st.top() << " "; st.pop(); }

}
