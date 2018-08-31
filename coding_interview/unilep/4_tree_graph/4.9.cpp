#include<bits/stdc++.h>
using namespace std;

struct Tree {
    string c;
    int data;
    Tree* left;
    Tree* right;
    Tree(int data, string c) : data(data), c(c) { }
    void addLeft(Tree* tree) { left = tree; }
    void addRight(Tree* tree) { right = tree; }
};

void search(Tree* tree, int N, int cur, string trees) {
    if(cur == N) {
        cout << trees << '\n';
    }
    if(tree->left != nullptr) {
        search(tree->left, N, cur + tree->left->data, trees + tree->left->c);
        search(tree->left, N, tree->left->data, tree->left->c);
    }
    if(tree->right != nullptr) {
        search(tree->right, N, cur + tree->right->data, trees + tree->right->c);
        search(tree->right, N, tree->right->data, tree->right->c);
    }
    
}

int main() {
    Tree* root = new Tree(0, "r");
    Tree* a = new Tree(3, "a");
    Tree* b = new Tree(-2, "b");
    Tree* c = new Tree(5, "c");
    Tree* d = new Tree(0, "d");
    Tree* e = new Tree(1, "e");
    Tree* f = new Tree(-6, "f");
    Tree* g = new Tree(-2, "g");
    Tree* h = new Tree(3, "h");
    Tree* i = new Tree(3, "i");

    root->addLeft(a);
    root->addRight(b);
    a->addLeft(c);
    a->addRight(d);
    b->addLeft(e);
    b->addRight(f);
    c->addLeft(g);
    c->addRight(h);
    d->addLeft(i);

    search(root, 3, 0, "r");
}
