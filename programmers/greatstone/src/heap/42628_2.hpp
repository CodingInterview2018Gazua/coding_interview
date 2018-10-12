// 문제: https://programmers.co.kr/learn/courses/30/lessons/42628
// 풀이: 최솟 값을 먼저 빼내는 우선 순위 큐와 최댓 값을 먼저 빼내는 우선 순위 큐 두개를 이용.
//      삽입은 두 개의 큐에 모두 수행, 삭제는 한쪽에서 삭제 후 삭제되었음을 플래깅
//      큐를 처리할 때 삭제 플래깅 된 항목은 무시함.

#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

struct Item {
    int number;
    bool deleted;
    
    Item(int _number): number(_number), deleted(false) {}
};

class ComparatorAsc {
public:
    bool operator() (const Item* left, const Item* right) {
        return left->number > right->number;
    }
};

class ComparatorDesc {
public:
    bool operator() (const Item* left, const Item* right) {
        return left->number < right->number;
    }
};

vector<int> solution(vector<string> operations) {
    priority_queue<Item*, vector<Item*>, ComparatorDesc> desc_pq;
    priority_queue<Item*, vector<Item*>, ComparatorAsc> asc_pq;
    for (string operation : operations) {
        char command;
        int number;
        sscanf(operation.c_str(), "%c %d", &command, &number);
        if (command == 'I') {
            Item* item = new Item(number);
            asc_pq.push(item);
            desc_pq.push(item);
        } else if (command == 'D') {
            if (number == 1) {
                while (!desc_pq.empty() && desc_pq.top()->deleted) {
                    Item* item = desc_pq.top();
                    desc_pq.pop();
                    delete item;
                }
                if (!desc_pq.empty()) {
                    desc_pq.top()->deleted = true;
                    desc_pq.pop();
                }
            } else if (number == -1) {
                while (!asc_pq.empty() && asc_pq.top()->deleted) {
                    Item* item = asc_pq.top();
                    asc_pq.pop();
                    delete item;
                }
                if (!asc_pq.empty()) {
                    asc_pq.top()->deleted = true;
                    asc_pq.pop();
                }
            }
        }
    }
    while (!asc_pq.empty() && asc_pq.top()->deleted) {
        Item* item = asc_pq.top();
        asc_pq.pop();
        delete item;
    }
    while (!desc_pq.empty() && desc_pq.top()->deleted) {
        Item* item = desc_pq.top();
        desc_pq.pop();
        delete item;
    }
    vector<int> answer;
    if (asc_pq.empty()) {
        answer.push_back(0);
        answer.push_back(0);
    } else {
        answer.push_back(desc_pq.top()->number);
        answer.push_back(asc_pq.top()->number);
    }
    return answer;
}
