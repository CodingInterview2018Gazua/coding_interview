#include <iostream>
#include<queue>
using namespace std;

struct Node {
	Node* left = nullptr;
	Node* right = nullptr;
	void addLeft(Node* node) {
		left = node;
	}
	void addright(Node* node) {
		right = node;
	}
};

bool isBalancedTree(Node* root) {
	queue<Node*> q;
	q.push(root);

	bool b = false;

	while (!q.empty()) {
		Node* node = q.front();
		q.pop();
		
		bool cur = false;

		if (node->left == nullptr && node->right == nullptr)
			continue;

		if (node->left == nullptr && node->right != nullptr) {
			return false;
		}

		if (node->left == nullptr || node->right == nullptr) {
			if (b) return false;
			cur = true;
			b = true;
		}

		if (node->left != nullptr) {
			if (!cur && b) return false;
			q.push(node->left);
		}
		if (node->right != nullptr) {
			if (!cur && b) return false;
			q.push(node->right);
		}
	}
	return true;

}

int main() {
	
	Node* root = new Node;
	Node* A = new Node;
	root->addLeft(A);
	
	Node* B = new Node;
	root->addright(B);

	Node* C = new Node;
	A->addLeft(C);

	Node* D = new Node;
	A->addright(D);

	Node* E = new Node;
	B->addLeft(E);

	Node* F = new Node;
	B->addright(F);

	cout << (isBalancedTree(root) ? "Balanced " : "Not Balanced") << '\n';
	
}
