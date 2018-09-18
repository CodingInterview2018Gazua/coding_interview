#include<bits/stdc++.h>
using namespace std;

int N, A[1001], D[1001], ans;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) cin >> A[i];
    for(int i=0; i<N; i++) {
        D[i] = 1;
        for(int j=0; j<i; j++) {
            if(A[i] > A[j] && D[i] < D[j] + 1)
                D[i] = D[j] + 1;
        }
    }
    for(int i=0; i<N; i++) {
        ans = max(ans, D[i]);
    }
    cout << ans;
}
