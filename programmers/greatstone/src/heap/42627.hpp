#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

class ComparatorForRquiredTime {
public:
    bool operator() (const vector<int>& v1, const vector<int>& v2) {
        return v1[1] > v2[1];
    }
};

bool compare_request_time(const vector<int>& v1, const vector<int>& v2) {
    return v1[0] < v2[0];
}

int solution(vector<vector<int>> jobs) {
    sort(jobs.begin(), jobs.end(), compare_request_time);
    priority_queue<vector<int>, vector<vector<int>>, ComparatorForRquiredTime> pq;
    int time = 0;
    int take_time = 0;
    int job_index = 0;
    while (!pq.empty() || job_index < jobs.size()) {
        if (pq.empty()) {
            time = max(time, jobs[job_index][0]);
        }
        while(job_index < jobs.size() && jobs[job_index][0] <= time) {
            pq.push(jobs[job_index]);
            ++job_index;
        }
        take_time += (time - pq.top()[0] + pq.top()[1]);
        time += pq.top()[1];
        cout << take_time << " " << pq.top()[0] << endl;
        pq.pop();
    }
    return take_time / jobs.size();
}
