#include<bits/stdc++.h>
using namespace std;
const int INF = -987654321;

int N;
struct Node {
    string str;
    int sum;
    void f(){
        for(int i=0; i<str.length(); i++) {
            if(str[i] >= '0' && str[i] <= '9') {
                sum += str[i] - '0';
            }
        }
    }
    bool operator<(const Node& node) const {
        if(str.length() != node.str.length()) {
            return str.length() < node.str.length();
        }
        if(sum == node.sum) return str < node.str;
        return sum < node.sum;
    }
};
Node A[1001];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> A[i].str;
        A[i].f();
    }
    sort(A, A + N);
    for(int i=0; i<N; i++) {
        cout << A[i].str << '\n';
    }
}
