#include<bits/stdc++.h>
using namespace std;

int main() {
    int N = 2048, M = 19, i = 2, j = 6;
    // N =      100000000000 2048
    // M =             10011   19
    // output = 100001001100 2124

    for(int k=i; k<=j; k++) {
        N = N & ~(1 << k);
        if(M % 2) N = N | (1 << k);
        M /= 2;
    }

    vector<int> A;
    while(N) {
        A.push_back(N % 2);
        N /= 2;
    }
    reverse(A.begin(), A.end());
    for(int i=0; i<A.size(); i++) {
        cout << A[i];
    }

}
