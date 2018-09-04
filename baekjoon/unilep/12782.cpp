#include<bits/stdc++.h>
using namespace std;

const int MAX = 1000001;
int T, ans;
string A, B;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> T;
    while(T--) {
        ans = 0;
        cin >> A >> B;
        if(A == B) {
            cout << 0 << '\n';
            continue;
        }
        int len = A.length();
        int diff[2] = {0, };
        for(int i=0; i<len; i++) {
            if(A[i] != B[i]) diff[A[i] - '0']++;
        }
        cout << diff[0] + diff[1] - min(diff[0], diff[1]) << '\n';
    }
}
