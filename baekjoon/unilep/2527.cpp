#include<bits/stdc++.h>
using namespace std;

int A[5], B[5];
char C[] = {'d','c','b',' ','a'};

int func(int a1, int a2, int b1, int b2) {
    if(a2 == b1 || a1 == b2) return 1;
    if(a2 < b1 || a1 > b2) return 0;
    return 2;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    for(int t=0; t<4; t++) {
        for(int i=0; i<4; i++) cin >> A[i];
        for(int i=0; i<4; i++) cin >> B[i];
        cout << C[func(A[0], A[2], B[0], B[2]) * func(A[1], A[3], B[1], B[3])] << '\n';
    }
}
