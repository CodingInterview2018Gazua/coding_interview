#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    sort(citations.begin(), citations.end());
    int h_index = citations.size();
    for (int i = 0; i < citations.size(); ++i) {
        if (citations[i] >= citations.size() - i) {
            return citations.size() - i;
        }
    }
    return 0;
}
