#include <string>
#include <vector>
#include<iostream>
using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
    for(int i=1; i<=10000; i++) {
        for(int j=1; j<=i; j++) {
            if(i * j == red) {
                int p = i * 2;
                int q = j * 2;
                if(brown + red == p + q + 4 + i * j) {
                    return { i+2, j+2 };
                }
            }
        }
    }
}
