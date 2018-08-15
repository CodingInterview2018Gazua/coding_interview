/*
 Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 
 EXAMPLE
 Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
 Output:2 -> 1 -> 9.That is,912.
 
 FOLLOW UP
 Suppose the digits are stored in forward order. Repeat the above problem.
 
 EXAMPLE
 lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 Output:9 -> 1 -> 2.Thatis,912.
 
 Hints: #7, #30, #71, #95, #109
 */


#include <iostream>
#include <list>
#include <stack>

using namespace std;

list<int> sum_list(list<int> &a, list<int> &b) {
    list<int> ans;
    int carry = 0;
    list<int>::iterator it_a = begin(a);
    list<int>::iterator it_b = begin(b);
    while(it_a != end(a) && it_b != end(b)) {
        int v = carry + *it_a + *it_b;
        carry = v / 10;
        ans.push_back(v % 10);
        
        ++it_a;
        ++it_b;
        
    }
    while(it_a != end(a)) {
        int v = (carry + *it_a);
        carry = v / 10;
        ans.push_back(v % 10);
        ++it_a;
    }
    while(it_b != end(b)) {
        int v = (carry + *it_b);
        carry = v / 10;
        ans.push_back(v % 10);
        ++it_b;
    }
    return ans;
}


list<int> sum_list_forward(list<int> &a, list<int> &b) {
    list<int> ans;
    stack<int> st_a;
    stack<int> st_b;
    
    int carry = 0;
    
    for(auto &&it: a) {
        st_a.push(it);
    }
    for(auto &&it: b) {
        st_b.push(it);
    }
    
    
    while(!st_a.empty() && !st_b.empty()) {
        int it_a = st_a.top();
        int it_b = st_b.top();
        int v = carry + it_a + it_b;
        carry = v / 10;
        ans.push_back(v % 10);
        
        st_a.pop();
        st_b.pop();
        
    }
    while(!st_a.empty()) {
        int it_a = st_a.top();
        int v = (carry + it_a);
        carry = v / 10;
        ans.push_back(v % 10);
        st_a.pop();
    }
    while(!st_b.empty()) {
        int it_b = st_b.top();
        int v = (carry + it_b);
        carry = v / 10;
        ans.push_back(v % 10);
        st_b.pop();
    }
    return ans;
}

void test() {
    
    list<int> a1 = {7, 1, 6};
    list<int> b1 = {5, 9, 2};
    
    list<int> ans;
    
    ans = sum_list(a1, b1);
    for(auto &&it : ans) {
        cout << it;
    }
    cout << endl;
    
    list<int> a2 = {6, 1, 7};
    list<int> b2 = {2, 9, 5};
    
    ans = sum_list_forward(a2, b2);
    for(auto &&it : ans) {
        cout << it;
    }
    cout << endl;
    
    
}
int main(int argc, const char * argv[]) {
    test();
    return 0;
}

