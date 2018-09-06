#include<bits/stdc++.h>
using namespace std;

int tobinary(int x) {
    int cnt = 0;
    while(x) {
        int k = x % 2;
        if(k & 1) cnt++;
        x /= 2;
    }
    return cnt;
}

void print(int x) {
    vector<int> v;
    while(x) {
        v.push_back(x % 2);
        x /= 2;
    }
    reverse(v.begin(), v.end());
    for(int k : v) cout << k;
    cout << '\n';
}

int main() {
    int N = 77; // 01001101
    cout << "N is : ";
    print(N);
    int one = tobinary(N);
    int X = N, Y = N;
    bool mx = false, mn = false;
    while(!mx || !mn) {
        if(!mx) {
            X++;
            int x_cnt = tobinary(X);
            if(one == x_cnt) {
                mx = true;
                cout << "greater than : " << X << " -> ";
                print(X);
            }
        }
        if(!mn) {
            Y--;
            int y_cnt = tobinary(Y);
            if(one == y_cnt) {
                mn = true;
                cout << "less than : " << Y << " -> ";
                print(Y);
            }
        }
    }
}
