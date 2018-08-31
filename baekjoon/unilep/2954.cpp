#include<bits/stdc++.h>
using namespace std;

string A;
string C = "aeiou";
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    getline(cin, A);
    for(int i=0; i<A.length(); i++) {
        char a = A[i];
        if(i+2 < A.length()) {
            char b = A[i+1];
            char c = A[i+2];
            bool is = false;
            for(int j=0; j<5 && !is; j++) {
                if(a == C[j] && b == 'p' && c == C[j]) is = true;
            }
            if(is) i+=2;   
        }
        
        cout << a;
    }
}
