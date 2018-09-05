#include<bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    while(true) {
        string s;
        cin >> s;
        if(s == "#") break;
        int one = 0;
        for(int i=0; i<s.length(); i++) {
            if(s[i] == '1') one++;
        }
        char c = s[s.length() - 1];
        if(c == 'o') {
            if(!(one & 1)) s[s.length() - 1] = '1';
            else s[s.length() - 1] = '0';
        } else {
            if(one & 1) s[s.length() - 1] = '1';
            else s[s.length() - 1] = '0';
        }
        cout << s << '\n';
    }
}
