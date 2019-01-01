#include<iostream>
#include<algorithm>
using namespace std;
int N, A[100001], ans = 2147483647, x, y;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> N;
	for(int i=0; i<N; i++) {
		cin >> A[i];
	}
	sort(A, A+N);
	for(int i=0; i<N; i++) {
		int item = A[i];
		int lo = 0;
		int hi = N-1;
		int target = -item;
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			if (A[mid] == target) {
				cout << item << " " << target;
				return 0;
			} else if(A[mid] >= target) {
				hi = mid - 1;
			} else if(A[mid] <= target) {
				lo = mid + 1;
			}
			int k = abs(item + A[mid]);
			if(ans > k && i != mid) {
				ans = k;
				x = item;
				y = A[mid];
			}
		}
	}
	if(A[0] > 0 && A[N-1] > 0) {
		cout << A[0] << " " << A[1];
	} else if(A[0] < 0 && A[N-1] < 0) {
		cout << A[N-2] << " " << A[N-1];
	} else {
		if(x<y) {
			cout << x << " " << y;
		} else {
			cout << y << " " << x;
		}
	}
}
