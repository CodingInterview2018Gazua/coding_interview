#include<bits/stdc++.h>
using namespace std;

int T;
string A, B;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> T;
    while(T--) {
        cin >> A >> B;
        int ans = 0;
        for(int i=0; i<A.length(); i++) {
            if(A[i] != B[i]) ans++;
        }
        cout << "Hamming distance is " << ans << "." << '\n';
    }
}
