#include<bits/stdc++.h>
using namespace std;
string A;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    while(true) {
        getline(cin, A);
        if(A == "*") break;
        int status = 0;
        for(int i=0; i<A.length(); i++) {
            if(A[i] == ' ') continue;
            int k = A[i] - 'a';
            status |= (1 << k);
        }
        cout << (status == ((1 << 26) - 1) ? "Y" : "N") << '\n';
    }
}
