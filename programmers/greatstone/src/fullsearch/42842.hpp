#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int red) {
    int max_row = brown / 4 + 1;
    for (int row = 1; row <= max_row; ++row) {
        int col = brown / 2 - row + 2;
        if ((col - 2) * (row - 2) == red) {
            return vector<int>{col, row};
        }
    }
    return vector<int>();
}