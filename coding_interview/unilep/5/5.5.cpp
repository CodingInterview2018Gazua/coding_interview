#include<bits/stdc++.h>
using namespace std;
const int INF = -987654321;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int N = 31, M = 14;
    int X = N ^ M;
    int cnt = 0;
    while(X){
        if(X&1) cnt++;
        X = X >> 1;
    }
    cout<<cnt;
}
