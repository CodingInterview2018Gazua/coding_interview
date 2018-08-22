#include<iostream>
using namespace std;

const int MAX = 100;
const char lf = '\n';

int A[3][MAX];

void push(int which, int value) {
	if (A[which][0] == MAX) {
		cout << which << " stack is full" << lf;
		return;
	}
	A[which][++A[which][0]] = value;
}

int getTop(int which) {
	return A[which][0] >= 0 ? A[which][A[which][0]] : -1;
}

void pop(int which) {
	if (A[which][0] >= 0)
		A[which][A[which][0]--];
}

bool isEmpty(int which) {
	return A[which][0] > 0;
}

int main() {
	push(0, 3); /* [ 3 ] */
	push(0, 5); /* [ 3, 5 ] */
	push(0, 2); /* [ 3, 5, 2 ] */

	push(1, 1); /* [ 1 ] */
	push(2, -1); /* [ -1 ] */
	push(0, 2); /* [ 3, 5, 2, 2 ] */

	while (isEmpty(0)) {
		cout << 0 << " : " << getTop(0) << '\n';
		pop(0);
	}

	while (isEmpty(1)) {
		cout << 1 << " : " << getTop(1) << '\n';
		pop(1);
	}

	while (isEmpty(2)) {
		cout << 2 << " : " << getTop(2) << '\n';
		pop(2);
	}

	push(0, 1); /* [ 1 ] */
	push(0, 2); /* [ 1, 2] */
	push(0, 3); /* [ 1, 2, 3 ] */

	while (isEmpty(0)) {
		cout << 0 << " : " << getTop(0) << '\n';
		pop(0);
	}
}
