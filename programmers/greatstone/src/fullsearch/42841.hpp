#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool check(int number1, int number2, int strike, int ball) {
    int number11 = number1 / 100;
    int number12 = number1 / 10 % 10;
    int number13 = number1 % 10;
    int number21 = number2 / 100;
    int number22 = number2 / 10 % 10;
    int number23 = number2 % 10;
    int count_strike = 0;
    int count_ball = 0;
    if (number11 == number21) ++count_strike;
    if (number12 == number22) ++count_strike;
    if (number13 == number23) ++count_strike;
    int count_digit1[10] = {0, };
    ++count_digit1[number11];
    ++count_digit1[number12];
    ++count_digit1[number13];
    int count_digit2[10] = {0, };
    ++count_digit2[number21];
    ++count_digit2[number22];
    ++count_digit2[number23];
    for (int i = 0; i < 10; ++i) {
        count_ball += min(count_digit1[i], count_digit2[i]);
    }
    count_ball -= count_strike;
    return strike == count_strike && ball == count_ball;
}

int solution(vector<vector<int>> baseball) {
    int answer = 0;
    for (int i = 1; i < 10; ++i) {
        for (int j = 1; j < 10; ++j) {
            if (i == j) continue;
            for (int k = 1; k < 10; ++k) {
                if (k == i || k == j) continue;
                int number = 100*i + 10*j + k;
                bool isAvailable = true;
                for (vector<int> item : baseball) {
                    if (!check(number, item[0], item[1], item[2])) {
                        isAvailable = false;
                        break;
                    }
                }
                if (isAvailable) {
                    cout << number << endl;
                    ++answer;
                }
            }
        }
    }
    return answer;
}