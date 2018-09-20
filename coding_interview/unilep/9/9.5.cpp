#include <iostream>
#include<cstring>
#include <vector>
#include<string>
using namespace std;

void func(string s, int idx, int N, int k) {    
    if(k == N) {
        cout << s << endl;
        return;
    }

    for(int i=idx; i<N; i++) {
        swap(s[i], s[idx]);
        func(s, idx+1, N, k+1);
        swap(s[i], s[idx]);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    string str = "abcde";
    func(str, 0, str.size(), 0);
    return 0;
}
