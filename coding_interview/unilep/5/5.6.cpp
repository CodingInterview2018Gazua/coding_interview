#include<bits/stdc++.h>
using namespace std;
const int INF = -987654321;
vector<int> tobinary(int x) {
    vector<int> v;
    while(x) {
        v.push_back(x % 2);
        x /= 2;
    }
    while(v.size() != 32) v.push_back(0);
    reverse(v.begin(), v.end());
    return v;
}
void binaryPrint(int x) {
    vector<int> v = tobinary(x);
    for(int k : v) cout << k;
    cout<<'\n';
}

int changeBit(int x) {
    int ret = 0;
    for(int i=0; x; i+=2) {
        int lo = x & (1 << i);
        int ri = x & (1 << (i+1));
        if(lo) ret |= (1 << (i+1));
        if(ri) ret |= (1 << i);
        x = x & ~(1 << i);
        x = x & ~(1 << (i+1));
    }
    return ret;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int N = 186;
    binaryPrint(N);
    int K = changeBit(N);
    binaryPrint(K);
}
