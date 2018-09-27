#include <string>
#include <vector>
#include<iostream>
#include<cstring>
using namespace std;
int ans = 0;
bool visit[10000000];
int cnt[10];
int _stoi(const string& s) {
    int k = 0;
    for(int i=0; i<s.length(); i++) {
        k = k * 10 + s[i] - '0';
    }
    return k;
}
void f(const string& numbers, string current) {
    if(current.length() > numbers.length()) return;
    int cur = _stoi(current);
    visit[cur] = true;
    bool isprime = true;
    for(int i=2; i * i <= cur && isprime; i++) {
        if(cur % i == 0) isprime = false;
    }
    if(cur >= 2 && isprime) {
        ans++;
    }
    for(int i=0; i<numbers.length(); i++) {
        if(cnt[numbers[i] - '0'] > 0) {
            int k = _stoi(current + numbers[i]);
            if(!visit[k]) {
                cnt[numbers[i] - '0']--;
                f(numbers, current + numbers[i]);
                cnt[numbers[i] - '0']++;
            }
        }
        
    }
}

int solution(string numbers) {
    ans = 0;
    memset(cnt, 0, sizeof(cnt));
    for(int i=0; i<numbers.length(); i++) {
        cnt[numbers[i] - '0']++;
    }
    memset(visit, false, sizeof(visit));
    f(numbers, "");
    return ans;
}
