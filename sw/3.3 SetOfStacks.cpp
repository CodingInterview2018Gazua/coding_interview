
//  SetOfStacks.cpp
//  Algorithm
//
//  Created by sw on 2018. 08. 17
//  Copyright © 2018년 sw. All rights reserved.
//

#include <iostream>
#include <algorithm>
#define MAX 100
#define STACK_SIZE 20

using namespace std;
class Stack{
private:
    int* buffer;
    int top;
    int capacity;
public:
    Stack(int _capacity=STACK_SIZE){
        buffer=new int[_capacity];
        top=-1;
        capacity=_capacity;
    }
    void push(int input){
        buffer[++top]=input;
    }
    void pop(){
        --top;
    }
    int getTop(){
        return buffer[top];
    }
    bool isEmpty(){
        return top==-1;
    }
    bool isFull(){
        return top==capacity-1;
    }
};
class SetOfStacks{
private:
    Stack* st;
    int top;
    int capacity;
public:
    SetOfStacks(int _capacity=MAX){
        st=new Stack[_capacity];
        top=0;
        capacity=_capacity;
    }
    ~SetOfStacks(){
        delete [] st;
    }
    void push(int input){
        if(st[top].isFull())
            ++top;
        st[top].push(input);
    }
    void pop(){
        if(st[top].isEmpty())
            --top;
        st[top].pop();
    }
    int getTop(){
        if(st[top].isEmpty())
            --top;
        return st[top].getTop();
    }
    bool isEmpty(){
        if(top==0)
            return st[0].isEmpty();
        else
            return false;
    }
    bool isFull(){
        if(top==capacity-1)
            return st[top].isFull();
        else
            return false;
    }
};
int main(void){
    SetOfStacks s;
    for(int i=0;i<STACK_SIZE+1;i++){
        s.push(i);
    }
    while(!s.isEmpty()){
        cout<<s.getTop()<<endl;
        s.pop();
    }
    return 0;
}

