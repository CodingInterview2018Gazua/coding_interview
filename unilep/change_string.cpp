#include<iostream>
#include<string>
using namespace std;

const string c = "%20";

string changeString(string A) {
   const int len = A.length();
   const int clen = c.length();
   for (int i = 0; i<len; i++) {
      if (A[i] == ' ') {
         if (i + clen + 1 >= len) break;
         A = A.substr(0, i) + c + A.substr(i + 1, len);
      }
   }
   return A;
}

int main() {
   cout << changeString("A B C      ") << '\n';
   cout << changeString("Mr John Smith    ") << '\n';
}