#include<bits/stdc++.h>
using namespace std;
const int INF = 987654321;
int N, K, A, B, D[1001][1001], P[1001];
string s[1001];
bool visit[1001];
struct Node {
    int no;
    string ans;
};
int hamming_code(const string& a, const string& b) {
    int cnt = 0;
    for(int i=0; i<K; i++) {
        if(a[i] != b[i]) cnt++;
    }
    return cnt;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> N >> K;
    for(int i=1; i<=N; i++) {
        cin >> s[i];
        P[i] = i;
    }
    for(int i=1; i<=N; i++) {
        for(int j=i+1; j<=N; j++) {
            int cost = hamming_code(s[i], s[j]);
            D[i][j] = D[j][i] = cost;
        }
    }
    cin >> A >> B;
    queue<Node> q;
    q.push({A, to_string(A)});
    visit[A] = true;
    while(!q.empty()) {
        Node node = q.front(); 
        int no = node.no;
        string ans = node.ans;
        q.pop();
        for(int i=1; i<=N; i++) {
            if(no == i) continue;
            if(visit[i]) continue;
            if(D[i][no] != 1) continue;
            q.push({ i, ans + " " + to_string(i)});
            visit[i] = true;
            if(i == B) {
                cout << ans << " " + to_string(B);
                return 0;
            }
        }
    }
    cout << -1;
}
