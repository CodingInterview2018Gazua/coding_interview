#include <bits/stdc++.h>
// cmd opt c - compile
// cmd opt r - execute
using namespace std;
int a, b, c, d;

int go(int x, int y) { 
	if (x >= 0 && -1 * x <= y&& y <= x) 
		return (x * 2 + 1)*(x * 2 + 1) - (x - y);
	else if (x<0 && x <= y && y <= abs(x) ) { 
		return (abs(x) * 2)*(abs(x) * 2) - (abs(x)-1) -y; 
	} else if (y>x&& y>-1*x) { 
		return ((y - 1) * 2 +1 )* ((y - 1) * 2 + 1) + (y - x); 
	} 
	return (abs(y) * 2)*(abs(y) * 2) + (x - y + 1);
}

int main() {
	scanf("%d %d %d %d", &a, &b, &c, &d);
	int k = to_string(max({go(a, b), go(c,d), go(a,d), go(b,c)})).size();

	for(int i=a; i<=c; i++) {
		for(int j=b; j<=d; j++) {
			printf("%*d ", k, go(i, j));
		}
		puts("");
	}
	return 0;
}
