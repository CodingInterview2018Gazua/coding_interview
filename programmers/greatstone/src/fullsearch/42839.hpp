#include <string>
#include <vector>
#include <iostream>

using namespace std;

int max_number = 10000000;
vector<bool> isNotPrime(max_number, false);
void find_primes() {
    isNotPrime[0] = isNotPrime[1] = true;
    for (int i = 2; i * i < max_number; ++i) {
        if (isNotPrime[i]) continue;
        for (int j = i * 2; j < max_number; j += i) {
            isNotPrime[j] = true;
        }
    }
}

int count_prime_permutation(string& numbers, vector<bool>& generated, vector<bool>& used, int number, int depth) {
    int count = 0;
    for (int i = 0; i < numbers.size(); ++i) {
        if (!used[i]) {
            used[i] = true;
            int tmp_number = number * 10 + (numbers[i] - '0');
            if (!generated[tmp_number] && !isNotPrime[tmp_number]) {
                ++count;
            }
            generated[tmp_number] = true;
            if (depth != numbers.size()) {
                count += count_prime_permutation(numbers, generated, used, tmp_number, depth + 1);
            }
            used[i] = false;
        }
    }
    return count;
}

int solution(string numbers) {
    find_primes();
    vector<bool> generated(max_number, false);
    vector<bool> used(numbers.size(), false);
    int answer = count_prime_permutation(numbers, generated, used, 0, 1);
    return answer;
}