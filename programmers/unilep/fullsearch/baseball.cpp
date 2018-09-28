#include <string>
#include <vector>
#include<iostream>
using namespace std;

int solution(vector<vector<int>> baseball) {
    int answer = 0;
    for(int i=123; i<=987; i++) {
        string a = to_string(i);
        bool is = true;
        
        bool numbers[10] = {false, };
        int x = i;
        while(x && is) {
            int k = x % 10;
            if(!k || numbers[k]) is = false;
            numbers[k] = true;
            x /= 10;
        }
        
        for(int j=0; j<baseball.size() && is; j++) {
            int k = baseball[j][0];
            int strike = baseball[j][1];
            int ball = baseball[j][2];
            string b = to_string(k);
            int my_strike = 0, my_ball = 0;
            for(int p=0; p<3; p++) {
                for(int q=0; q<3; q++) {
                    if(a[p] == b[q]) {
                        if(p == q) my_strike++;
                        else my_ball++;
                    }    
                }
            }
            if(strike != my_strike || ball != my_ball) is = false;
        }
    }
    return answer;
}
