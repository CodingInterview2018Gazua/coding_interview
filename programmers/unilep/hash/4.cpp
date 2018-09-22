#include <string>
#include <vector>
#include<map>
#include<algorithm>
#include<iostream>
using namespace std;

struct Node {
    string name;
    int play_count;
    bool operator<(const Node& node) const {
        return play_count > node.play_count;
    }
};

struct Music {
    int plays;
    int key;
    bool operator<(const Music& music) const {
        return plays > music.plays;
    }
};

vector<int> solution(vector<string> genres, vector<int> plays) {
    map<string, int> cntMap;
    map<string, vector<Music>> mp;
    for(int i=0; i<genres.size(); i++) {
        cntMap[genres[i]] += plays[i];
        mp[genres[i]].push_back({plays[i], i});
    }
    vector<Node> cntVector;
    for(auto it = cntMap.begin(); it != cntMap.end(); it++) {
        cntVector.push_back({it->first, it->second});
    }
    sort(cntVector.begin(), cntVector.end());
    vector<int> answer;
    for(Node node : cntVector) {
        vector<Music> musics = mp[node.name];
        sort(musics.begin(), musics.end());
        answer.push_back(musics[0].key);
        if(musics.size() > 1) {
            answer.push_back(musics[1].key);
        }
    }
    return answer;
}
