#include <iostream>
#include<cstring>
#include <vector>
using namespace std;

int N;
double D[1000001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> N;
    
    D[1] = 1.0;
    D[2] = D[1] / 6 + 1;
    D[3] = (D[1] + D[2]) / 6 + 1;
    D[4] = (D[1] + D[2] + D[3]) / 6 + 1;
    D[5] = (D[1] + D[2] + D[3] + D[4]) / 6 + 1;
    D[6] = (D[1] + D[2] + D[3] + D[4] + D[5]) / 6 + 1;
    for(int i=6; i<N+1; i++) {
        D[i] = (D[i-1] + D[i-2] + D[i-3] + D[i-4] + D[i-5] + D[i-6]) / 6 + 1;
    }
    cout.precision(15);
    cout << D[N];

    return 0;
}
