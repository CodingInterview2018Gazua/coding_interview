#include<iostream>
using namespace std;

const int MAX = 100;
const char lf = '\n';

int A[MAX], B[MAX];
int top, min_top;

void push(int value) {
	A[top++] = value;
	if (min_top == 0) {
		B[min_top++] = value;
		return;
	}
	B[min_top] = value < B[min_top - 1] ? value : B[min_top - 1];
	min_top++;
}

void pop() {
	top--;
	min_top--;
}

int min() {
	return B[min_top - 1];
}

int main() {
	push(5); // [ 5 ]
	push(1); // [ 5, 1 ]
	push(2); // [ 5, 1, 2 ]

	cout << min() << lf; // 1

	pop(); // [ 5, 1 ]
	pop(); // [ 5 ]
	
	cout << min() << lf;  // 5

	push(3);  // [ 5, 3 ]
	cout << min() << lf; // 3

	push(1);  // [ 5, 3, 1 ]
	cout << min() << lf; // 1

	push(5);  // [ 5, 3, 1, 5 ]
	cout << min() << lf; // 1

	while (top > 0) {
		cout << min() << lf;
		pop();
	}

}
