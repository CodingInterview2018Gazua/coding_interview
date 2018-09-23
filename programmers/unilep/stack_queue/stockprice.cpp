#include <string>
#include <vector>
#include<stack>
using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    stack<int> st;
    for(int i=0; i<prices.size(); i++) {
        int cur = prices[i];
        int c = 0;
        for(int j=i; j<prices.size() - 1; j++) {
            if(cur <= prices[j]) c++;
            else break;
        }
        answer.push_back(c);
    }
    
    return answer;
}
