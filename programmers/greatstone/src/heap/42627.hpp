//문제: https://programmers.co.kr/learn/courses/30/lessons/42627
//풀이: 1. 주어진 작업을 요청 시간으로 정렬
//     2. 소요시간이 작은 작업을 우선적으로 꺼내는 우선 순위 큐 사용
//     3. 새로운 작업이 가능한 시간에 그 동안 요청된 작업 중 소요 시간이 가장 작은 작업을 꺼내어 대기 시간 및 소요 시간 계산

#include <string>
#include <vector>
#include <queue>
#include <algorithm>

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
        pq.pop();
    }
    return take_time / jobs.size();
}
