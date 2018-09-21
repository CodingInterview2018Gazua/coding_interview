#include <string>
#include <vector>
#include <map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    map<string, int> mp;
    for(string s : participant) {
        mp[s]++;
    }
    for(string s : completion) {
        mp[s]--;
    }
    for(auto it : mp) {
        if(it.second) return it.first;
    }
}
