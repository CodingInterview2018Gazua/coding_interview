#include <iostream>
#include <string>
#include <algorithm>
#include <stack>
using namespace std;

class Stack{
private:
	struct sw_stack{
		int value;
		sw_stack* next;
	};
	sw_stack *top;
	sw_stack *min_top;

public:
	Stack(){
		top=nullptr;
		min_top=nullptr;
	}
	void push(int num){
		sw_stack* newNode=new sw_stack;
		newNode->value=num;
		if(isEmpty()){ //first push
			top=newNode;
			newNode->next=nullptr;

			min_top=newNode;
			newNode->next=nullptr;
		} else{ //exist data
			

			if(newNode->value <= min_top->value){ 
				newNode->next=min_top;
				min_top=newNode;
			}else{
				newNode->next=top;
				top=newNode;
			}

		}
	}
	void pop(int &result){
		sw_stack* temp = nullptr;
		sw_stack* mintemp=nullptr;

		if(isEmpty())
			cout<<"Empty"<<endl;
		else{
			result=top->value;
			if(top->value==min_top->value){
				mintemp = min_top->next;
				min_top=mintemp;
			}
			if(!min_top)
				cout<<"Minimual is Empty"<<endl;

			temp=top->next;
			top=temp;
		}
	}
	bool isEmpty(){
		return !top;
	}
	void get_min(int &node){
		node=min_top->value;
	}
};
void test(){
	int pop,min_va;
	Stack st;
	st.push(4);
	st.push(6);
	st.push(23);
	st.push(76);
	st.push(100);
	st.push(0);
	st.get_min(min_va);
	cout<<min_va<<endl;
	st.pop(pop);
	cout<<pop<<endl;
	st.get_min(min_va);
	cout<<min_va<<endl;

	st.pop(pop);
	cout<<pop<<endl;
	st.pop(pop);
	cout<<pop<<endl;
}
int main(void){
	test();	
	return 0;
}