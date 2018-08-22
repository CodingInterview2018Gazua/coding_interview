#include <iostream>
#include<queue>
using namespace std;

const int N = 5;
int A[N + 1], height;

struct Tree {
	int value;
	Tree* left;
	Tree* right;
	Tree() : value(-1), left(nullptr), right(nullptr) {	}
	void addLeft(Tree* tree) {
		left = tree;
	}
	void addRight(Tree* tree) {
		right = tree;
	}
};

void constructTree(Tree* tree, int lo, int hi, int h) {
	if (lo == hi) return;
	
	int mid = (lo + hi) / 2;
	tree->value = A[mid];
	
	if (height < h) height = h;

	if (tree->left == nullptr) tree->left = new Tree;
	if (tree->right == nullptr) tree->right = new Tree;

	constructTree(tree->left, lo, mid, h + 1);
	constructTree(tree->right, mid + 1, hi, h + 1);
}

void printTree(Tree* tree) {
	queue<Tree> q;
	q.push(*tree);
	while (!q.empty()) {
		
		int sz = q.size();
		for (int i = 0; i < sz; i++) {
			for (int j = 0; j < (1 << height); j++) cout << " ";
			Tree t = q.front();
			cout << t.value;
			
			if(t.left->value != -1) q.push(*t.left);
			if(t.right->value != -1) q.push(*t.right);
			q.pop();
		}
		cout << endl;
		height--;
		
	}
}

Tree* root = new Tree;

int main() {

	for (int i = 1; i <= N; i++) {
		A[i - 1] = i;
	}

	constructTree(root, 0, N, 0);

	printTree(root);

	return 0;
}
