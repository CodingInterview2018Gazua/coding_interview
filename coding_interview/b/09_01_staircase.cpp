#include <chrono>
#include <iostream>
using namespace std;
/*
1132436852
memo time: 4.0801e-05
1132436852
brute time: 9.7364
*/

const static int ARR_MAX = 1'000'000;
int howtosteps(int n) {
    if (n < 0) {
        return 0;
    }
    if (n == 0) {
        return 1;
    }
    return howtosteps(n - 1) + howtosteps(n - 2) + howtosteps(n - 3);
}
int howtosteps_memo(int n, int arr[]) {
    if (n < 0) {
        return 0;
    }
    if (n == 0) {
        return 1;
    }
    if (arr[n] != 0) {
        return arr[n];
    }
    arr[n] = howtosteps_memo(n - 1, arr) + howtosteps_memo(n - 2, arr) + howtosteps_memo(n - 3, arr);
    return arr[n];
}
int main() {
    int n = 35;

    std::chrono::high_resolution_clock::time_point t1, t2;
    std::chrono::duration<double> diff;

    /* memoziation */
    int arr[ARR_MAX] = {0};
    t1 = std::chrono::high_resolution_clock::now();
    cout << howtosteps_memo(n, arr) << endl;
    t2 = std::chrono::high_resolution_clock::now();
    diff = std::chrono::duration_cast<std::chrono::duration<double>>(t2 - t1);
    cout << "memo time: " << diff.count() << endl;

    /* brute force */
    t1 = std::chrono::high_resolution_clock::now();
    cout << howtosteps(n) << endl;
    t2 = std::chrono::high_resolution_clock::now();
    diff = std::chrono::duration_cast<std::chrono::duration<double>>(t2 - t1);
    cout << "brute time: " << diff.count() << endl;

    return 0;
}
