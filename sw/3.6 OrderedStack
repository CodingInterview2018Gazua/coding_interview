#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;
void sortStack(stack<int> st){
    stack<int> st2;
    while(!st.empty()){
        int temp=st.top();
        st.pop();
        while(!st2.empty()&&st2.top()>temp){
            st.push(st2.top());
            st2.pop();
        }
        st2.push(temp);
    }
    while(!st2.empty()){
        st.push(st2.top());
        st2.pop();
    }
    //print ordered stack
    while(!st.empty()){
        cout<<"ordered stack = "<<st.top()<<endl;
        st.pop();
    }
}
int main()
{
    stack<int> st;
    st.push(5);
    st.push(1);
    st.push(3);
    sortStack(st);

    return 0;
}
