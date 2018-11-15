/*
link: https://www.acmicpc.net/problem/13904
*/

#include <algorithm>
#include <functional>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct greater1 {
    bool operator()(const pair<int, int> &a, const pair<int, int> &b) {
        return a.second < b.second;
    }
};
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, d, w, ans;
    int deadline;
    vector<pair<int, int>> v;
    std::priority_queue<pair<int, int>, vector<pair<int, int>>, greater1> max_heap;

    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> d >> w;
        v.push_back(make_pair(d, w));
    }
    sort(begin(v), end(v));

    deadline = v.back().first;
    while (deadline != 0) {
        while (v.empty() == false && v.back().first == deadline) {
            max_heap.push(v.back());
            v.pop_back();
        }
        --deadline;
        if (max_heap.size() == 0)
            continue;
        ans += max_heap.top().second;
        max_heap.pop();
    }
    cout << ans;

    return 0;
}
