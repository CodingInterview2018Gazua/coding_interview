#include<bits/stdc++.h>
using namespace std;

struct Tree {
    int data;
    Tree* left;
    Tree* right;
    Tree(int data) : data(data), left(nullptr), right(nullptr) { }
    void addLeft(Tree* tree) {
        left = tree;
    }
    void addRight(Tree* tree) {
        right = tree;
    }
};

bool isSubTree(Tree* A, Tree* B) {
    if(A == nullptr || B == nullptr) return false;
    
    if(A->left == nullptr && A->right == nullptr && 
        B->left == nullptr && B->right == nullptr && A->data == B->data) return true;
    
    if(A->data == B->data) {
        return isSubTree(A->left, B->left) && isSubTree(A->right, B->right);
    }
    return isSubTree(A->left, B) || isSubTree(A->right, B);
}

int main() {
    Tree* root = new Tree(0);
    Tree* one = new Tree(1);
    Tree* two = new Tree(2);
    Tree* thr = new Tree(3);
    Tree* four = new Tree(4);
    Tree* five = new Tree(5);
    Tree* six = new Tree(6);
    Tree* svn = new Tree(7);
    Tree* eig = new Tree(8);
    Tree* nine = new Tree(9);
    Tree* ten = new Tree(10);

    root->addLeft(one);
    root->addRight(two);
    one->addLeft(thr);
    one->addRight(four);
    two->addLeft(five);
    two->addRight(six);
    thr->addLeft(svn);
    thr->addRight(eig);
    four->addLeft(nine);
    four->addRight(ten);
    /**                         0
     *              1                           2
     *      3               4              5           6
     * 7        8       9       10
     * 
    **/

    cout << (isSubTree(root, four) ? "OK" : "NO") << '\n'; // OK
    Tree* ele = new Tree(11);
    cout << (isSubTree(root, ele) ? "OK" : "NO") << '\n'; // NO

    Tree* t = new Tree(2);
    Tree* t2 = new Tree(5);
    Tree* t3 = new Tree(6);
    t->addLeft(t2);
    t->addRight(t3);
    /**
     *      2
     *  5       6
    **/
    cout << (isSubTree(root, t) ? "OK" : "NO") << '\n'; // OK

    t = new Tree(1);
    t2 = new Tree(3);
    t3 = new Tree(4);
    Tree* t4 = new Tree(7);
    Tree* t5 = new Tree(8);
    Tree* t6 = new Tree(9);
    Tree* t7 = new Tree(10);
    t->addLeft(t2);
    t->addRight(t3);
    t2->addLeft(t4);
    t2->addRight(t5);
    t3->addLeft(t6);
    t3->addRight(t7);
    /**
     *                  1
     *           3              4
     *      7       8       9       10
    **/

    cout << (isSubTree(root, t) ? "OK" : "NO") << '\n'; // OK
}
