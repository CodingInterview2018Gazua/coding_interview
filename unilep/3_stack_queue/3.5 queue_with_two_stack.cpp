#include<iostream>
#include<stack>
using namespace std;

struct Queue {
	stack<int> s1;
	stack<int> s2;

	void push(int x) {
		s1.push(x);
	}

	int pop() {
		if (s2.empty()) {
			while (!s1.empty()) {
				int k = s1.top();
				s1.pop();
				s2.push(k);
			}
		}
		int k = s2.top();
		s2.pop();
		return k;
	}
};

int main() {
	Queue q;
	q.push(1);
	q.push(2);
	q.push(3);

	cout << q.pop() << endl;
	cout << q.pop() << endl;

	q.push(1);
	q.push(2);
	cout << q.pop() << endl;
	cout << q.pop() << endl;
	cout << q.pop() << endl;

}
