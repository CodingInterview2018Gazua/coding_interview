// 문제: https://programmers.co.kr/learn/courses/30/lessons/42628
// 풀이: 최솟 값을 먼저 빼내는 우선 순위 큐와 최댓 값을 먼저 빼내는 우선 순위 큐 두개를 이용.
//      삽입은 두 개의 큐에 모두 수행, 삭제는 한쪽에서 삭제 후 삭제되었음을 플래깅
//      큐를 처리할 때 삭제 플래깅 된 항목은 무시함.

#include <string>
#include <vector>
#include <queue>

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

class bi_priority_queue {
private:
    priority_queue<Item*, vector<Item*>, ComparatorDesc> desc_pq;    
    priority_queue<Item*, vector<Item*>, ComparatorAsc> asc_pq;
    
    void adjust_desc_pq() {
        while (!desc_pq.empty() && desc_pq.top()->deleted) {
            Item* item = desc_pq.top();
            desc_pq.pop();
            delete item;
        }
    }
    
    void adjust_asc_pq() {
        while (!asc_pq.empty() && asc_pq.top()->deleted) {
            Item* item = asc_pq.top();
            asc_pq.pop();
            delete item;
        }
    }
public:
    void push(Item* item) {
        asc_pq.push(item);
        desc_pq.push(item);
    }
    
    Item* pop_min() {
        adjust_asc_pq();
        Item* item = NULL;
        if (!asc_pq.empty()) {
            item = asc_pq.top();
            item->deleted = true;
            asc_pq.pop();
        }
        return item;
    }
    
    bool empty() {
        adjust_asc_pq();
        return asc_pq.empty();
    }
    
    Item* pop_max() {
        adjust_desc_pq();
        Item* item = NULL;
        if (!desc_pq.empty()) {
            item = desc_pq.top();
            item->deleted = true;
            desc_pq.pop();
        }
        return item;
    }
};

vector<int> solution(vector<string> operations) {
    bi_priority_queue bpq;
    for (string operation : operations) {
        char command;
        int number;
        sscanf(operation.c_str(), "%c %d", &command, &number);
        if (command == 'I') {
            bpq.push(new Item(number));
        } else if (command == 'D') {
            if (number == 1) {
                bpq.pop_max();
            } else if (number == -1) {
                bpq.pop_min();
            }
        }
    }
    vector<int> answer;
    if (bpq.empty()) {
        answer.push_back(0);
        answer.push_back(0);
    } else {
        answer.push_back(bpq.pop_max()->number);
        answer.push_back(bpq.pop_min()->number);
    }
    return answer;
}
