#include <string>
#include <vector>
#include <list>
#include <iostream>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    list<pair<int, int>> bridge;
    int cur_weight = 0;
    int truck_index = 0;
    int answer = 1;
    while (!bridge.empty() || truck_index < truck_weights.size()) {
        if (truck_index < truck_weights.size() && cur_weight + truck_weights[truck_index] <= weight) {
            bridge.push_back(pair<int, int>(truck_weights[truck_index], answer));
            cur_weight += truck_weights[truck_index];
            ++truck_index;
            ++answer;
        } else {
            answer = bridge_length + bridge.front().second;
        }
        if (bridge.front().second + bridge_length <= answer) {
            cur_weight -= bridge.front().first;
            bridge.pop_front();
        }
    }
    return answer;
}