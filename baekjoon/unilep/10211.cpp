#include<bits/stdc++.h>
using namespace std;
const int INF = -987654321;
int T, N, D[1001], A[1001];

int func(int x) {
    if(x == N-1) return D[x] = A[N-1];
    int& ret = D[x];
    if(ret != INF) return ret;
    ret = max(A[x], func(x+1) + A[x]);
    return ret;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> T;
    while(T--) {
        memset(D, -1, sizeof(D));
        cin >> N;
        int ans = INF;
        for(int i=0; i<N; i++){
            cin >> A[i];
            D[i] = INF;
        }
        func(0);
        for(int i=0; i<N; i++) {
            ans = max(ans, D[i]);
        }
        cout << ans << '\n';
    }
}
