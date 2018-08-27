#include <iostream>
#include <stack>

using namespace std;

struct Node {
    Node(int _k)
        : k(_k), left(nullptr), right(nullptr) {
    }
    int k;
    Node *left, *right;
};

bool checkBalance(Node *root) {
    stack<Node *> s;
    s.push(root);
    while (!s.empty()) {
        Node *t = s.top();
        if (t->left != nullptr && t->right != nullptr) {
            if (t->left->k >= t->k || t->right->k <= t->k) {
                return false;
            }
        }
        s.pop();
        if (t->right != nullptr) {
            s.push(t->right);
        }
        if (t->left != nullptr) {
            s.push(t->left);
        }
    }
    return true;
}
void test() {
    Node *root = new Node(5);
    Node *one = new Node(1);
    Node *two = new Node(2);
    Node *three = new Node(3);
    Node *seven = new Node(7);
    Node *seven2 = new Node(7);

    root->left = three;
    root->right = seven;
    three->left = one;
    cout << checkBalance(root) << "\n";

    three->right = two;
    cout << checkBalance(root) << "\n";

    three->right = nullptr;
    seven->right = seven2;
    cout << checkBalance(root) << "\n";
}
int main() {
    test();
    return 0;
}
