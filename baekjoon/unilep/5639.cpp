#include<iostream>
using namespace std;

int A[10001], X, Ai;

struct Node {
	Node* left;
	Node* right;
	int value;
	Node(int x) : value(x) {
		left = right = nullptr;
	}
	void insert(int x) {
		int k = value;
		if (k > x) { //left
			if (left == nullptr) {
				left = new Node(x);
				return;
			}
			left->insert(x);
		}
		else {//right
			if (right == nullptr) {
				right = new Node(x);
				return;
			}
			right->insert(x);
		}
	}
};


void postord(Node* node) {
	if(node->left != nullptr) postord(node->left);
	if (node->right != nullptr) postord(node->right);
	cout << node->value << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	while (cin >> X) {
		A[Ai++] = X;
	}
	Node* root = new Node(A[0]);
	for (int i = 1; i < Ai; i++) {
		root->insert(A[i]);
	}
	postord(root);
}
