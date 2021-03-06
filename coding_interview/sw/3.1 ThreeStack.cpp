#include <iostream>
#include <algorithm>

using namespace std;
#define SIZE 10
int arr[SIZE];
int headPoint[3]={-1,-1,-1};

int getTop(int stackNum){
    return stackNum*SIZE + headPoint[stackNum];
}
void push(int input, int stackNum){
    headPoint[stackNum]++;
    arr[getTop(stackNum)]=input;
}
int pop(int stackNum){
    int result=arr[getTop(stackNum)];
    arr[getTop(stackNum)]=0;
    headPoint[stackNum]--;
    return result;
}
int peek(int stackNum){
    int result=arr[getTop(stackNum)];
    return result;
}
int main(int argc, const char * argv[]) {
    push(1, 0);
    push(2, 0);
    push(3,1);
    push(2,2);
    
    return 0;
}
