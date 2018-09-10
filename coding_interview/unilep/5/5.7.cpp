#include<bits/stdc++.h>
using namespace std;
const int INF = -987654321;

int getBit(int i, int j) {
    return (i & 1 << j);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    /**
     * 1 ~ N 까지의 데이터가 [1] ~ [N]에 들어있다고 가정
     * but notExistIndex(4) 값이 비어있다.
     * 고로, [1, 2, 3, -1, 5, 6, 7] 이 들어있다.
     * 1 ~ N 의 데이터 중에 빠진 정수를 찾아라.
     */ 
    int N = 7, notExistIndex = 4;
    int* A = new int[N+1];
    for(int i=1; i<=N; i++) {
        A[i] = i;
    }
    A[notExistIndex] = -1;
    int K = 0;
    for(int i=1; i<=N; i++) {
        K ^= i;
    }
    for(int i=1; i<=N; i++) {
        if(A[i] == -1) continue;
        int x = A[i];
        for(int j=0; x; j++) {
            K ^= getBit(A[i], j);
            x = x & ~(1 << j);
        }
    }
    cout << K;
}
