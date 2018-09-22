#include <string>
#include <vector>
#include<map>
using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> mp;
    for(vector<string> v : clothes) {
        mp[v[1]]++;
    }
    
    for(auto it = mp.begin(); it != mp.end(); it++) {
        answer *= (it->second + 1);
    }
    return answer - 1;
}
