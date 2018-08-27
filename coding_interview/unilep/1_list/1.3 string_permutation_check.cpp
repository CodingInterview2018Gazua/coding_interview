#include<iostream>
#include<string>
using namespace std;

const int MAX = 130;

bool isPermutation(const string& A, const string& B) {
   if (A.length() != B.length()) return false;

   int check[MAX] = { false, };
   for (int i = 0; i<A.length(); i++) {
      check[A[i]]++;
   }

   for (int i = 0; i<B.length(); i++) {
      check[B[i]]--;
   }

   for (int i = 0; i<MAX; i++) {
      if (check[i] != 0) return false;
   }
   return true;
}

int main() {
   cout << (isPermutation("abcabc", "bbccaa") ? "YES" : "NO") << '\n'; /* YES */
   cout << (isPermutation("A1B2c3", "321cBA") ? "YES" : "NO") << '\n'; /* YES */
   cout << (isPermutation("A1B2c3", "321cBA4") ? "YES" : "NO") << '\n'; /* NO */
   cout << (isPermutation("AAA", "a") ? "YES" : "NO") << '\n'; /* NO */
}