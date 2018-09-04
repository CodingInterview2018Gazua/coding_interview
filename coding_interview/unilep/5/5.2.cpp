#include<bits/stdc++.h>
using namespace std;

int main() {
    double d = 0.5;
    double f = 0.5;
    vector<int> v;
    const int MAX = 20;
    int k = 0;
    while(++k <= MAX) {
        if(d > f) {
            d -= f;
            f /= 2;
            v.push_back(1);
        }
        else if(d < f) {
            f /= 2;
            v.push_back(0);
        }
        else {
            v.push_back(1);
            break;
        }
    }
    for(int a : v) {
        cout << a;
    }
    
}
