#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

vector<string> g_genres;
vector<int> g_plays;
map<string, int> g_genre_map;

bool compare_play(int i1, int i2) {
    return g_plays[i1] > g_plays[i2];
}

bool compare_genre(int i1, int i2) {
    return g_genre_map[g_genres[i1]] > g_genre_map[g_genres[i2]];
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    g_genres.insert(g_genres.begin(), genres.begin(), genres.end());
    g_plays.insert(g_plays.begin(), plays.begin(), plays.end());
    vector<int> indexes;
    for (int i = 0; i < genres.size(); ++i) {
        g_genre_map[genres[i]] += plays[i];
        indexes.push_back(i);
    }
    sort(indexes.begin(), indexes.end(), compare_play);
    map<string, int> genre_count;
    vector<int> answer;
    for (int index : indexes) {
        if (genre_count[genres[index]] < 2) {
            answer.push_back(index);
            ++genre_count[genres[index]];
        }
    }
    sort(answer.begin(), answer.end(), compare_genre);
    return answer;
}
