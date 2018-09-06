#include<iostream>
#include<string>
#include<queue>
#include<stack>
using namespace std;
const int INF = 987654321;
int N, K, A, B, P[1001], Q[1001];
vector<int> V[1001];
bool visit[1001];
string s;

bool hamming_code(int a, int b) {
	int x = a ^ b;
	return (x & (-x)) == x;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N >> K;
	for (int i = 1; i <= N; i++) {
		cin >> s;
		int x = 0;
		for (int j = 0; j < K; j++) {
			x *= 2;
			x += (s[j] - '0');
		}
		Q[i] = x;
		P[i] = i;
	}
	for (int i = 1; i <= N; i++){
		for (int j = i + 1; j <= N; j++) {
			if (hamming_code(Q[i], Q[j])) {
				V[i].push_back(j);
				V[j].push_back(i);
			}
		}
	}
	cin >> A >> B;
	queue<int> q;
	q.push(A);
	visit[A] = true;
	while (!q.empty()) {
		int no = q.front(); q.pop();
		for (int next : V[no]) {
			if (visit[next]) continue;
			q.push(next);
			visit[next] = true;
			P[next] = no;
		}
	}
	if (!visit[B]) {
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
