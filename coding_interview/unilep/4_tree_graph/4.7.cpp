include <bits/stdc++.h>

using namespace std;

class Node {
    public:
        int data;
        Node *left;
        Node *right;
        Node(int d) {
            data = d;
            left = NULL;
            right = NULL;
        }
};

class Solution {
    public:
  		Node* insert(Node* root, int data) {
            if(root == NULL) {
                return new Node(data);
            } else {
                Node* cur;
                if(data <= root->data) {
                    cur = insert(root->left, data);
                    root->left = cur;
                } else {
                    cur = insert(root->right, data);
                    root->right = cur;
               }

               return root;
           }
        }
		Node* search(Node* root, int value) {
			Node* temp = root;
			while(temp != nullptr) {
				if(temp->data < value) {
					temp = temp->right;
				}
				else if(temp->data > value) {
					temp = temp->left;
				}
				else {
					break;
				}
			}
			return temp;
		}

		Node *lca(Node *root, int v1,int v2) {
			// Write your code here.
			Node* le = search(root, v1);
			Node* ri = search(root, v2);
			queue<Node*> q;
			q.push(root);
			Node* p[31] = {nullptr, };
			int d[31] = {0, };
			d[root->data] = 1;
			while(!q.empty()) {
				Node* node = q.front();
				Node* left = node->left;
				Node* right = node->right;
				int data = node->data;
				q.pop();
				if(left != nullptr) {
					p[left->data] = node;
					d[left->data] = d[data] + 1;
					q.push(left);
				}
				if(right != nullptr) {
					p[right->data] = node;
					d[right->data] = d[data] + 1;
					q.push(right);
				}
			}
			if(d[le->data] < d[ri->data]) swap(le, ri);
			while(d[le->data] != d[ri->data]) le = p[le->data];
			while(le != ri) {
				le = p[le->data];
				ri = p[ri->data];
			}
			return le;
		}
};


int main() {
  
    Solution myTree;
    Node* root = NULL;
    
    int t;
    int data;

    std::cin >> t;

    while(t-- > 0) {
        std::cin >> data;
        root = myTree.insert(root, data);
    }
  	
  	int v1, v2;
  	std::cin >> v1 >> v2;
  
    Node *ans = myTree.lca(root, v1, v2);
    
  	std::cout << ans->data;

    return 0;
}
