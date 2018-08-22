#include<iostream>
#include<string>
using namespace std;

bool isUpper(char c) {
   return c >= 'A' && c <= 'Z';
}

bool isLower(char c) {
   return c >= 'a' && c <= 'z';
}

bool isUniqueString(const string& str) {
   long long 
      upperStatus = 0l, /* 대문자 bit status */
      lowerStatus = 0l, /* 소문자 bit status */
      numericStatus = 0l; /* 숫자 bit status */

   const int len = str.length();
   for (int i = 0; i<len; i++) {
      const char c = str[i];
      if (isUpper(c)) { /* 대문자면 */
         int idx = 1 << (c - 'A'); 
         if (upperStatus & idx) /* set되있으면 not unique*/
            return false; 
         upperStatus |= idx; /* set 해주자 */
      }
      else if (isLower(c)) { /* 소문자면... 뒤에 로직은 동일*/
         int idx = 1 << (c - 'a');
         if (lowerStatus & idx) return false;
         lowerStatus |= idx;
      }
      else { /* 숫자면... */
         int idx = 1 << (c - '0');
         if (numericStatus & idx) return false;
         numericStatus |= idx;
      }
   }
   return true;
}

string print(const string& str) {
   return (isUniqueString(str) ? "YES\n" : "NO\n");
}

int main() {
   cout << print("abcdefg12345ABCDE"); // YES
   cout << print("abcdefg12345ABCDEa"); // NO
   cout << print("abcdefg12345ABCDE12345"); // NO
   cout << print("a3b2c1A4B5C"); // YES
}