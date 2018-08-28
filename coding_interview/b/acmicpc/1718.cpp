#include <iostream>
#include <cstring>
using namespace std;

#define N_ALPHA 26
char vigenere(char p, char k)
{
    char c = p - k;
    c = c % N_ALPHA;
    if (c < 0)
    {
        c = c + N_ALPHA;
    }
    return c + 'a';
}
void ciphering(const char *plain, size_t sz_plain, const char *key, size_t sz_key)
{
    cout << "(" << sz_plain << ")" << plain << endl;
    cout << "(" << sz_key << ")" << key << endl;
    for (int i = 0; i < sz_plain; ++i)
    {
        if (plain[i] == ' ')
        {
            cout << " ";
        }
        else
        {
            cout << vigenere(plain[i], key[i % sz_key]);
        }
    }
}
void test()
{
    char plain[30000];
    char key[30000];
    cin.getline(plain, 30000);
    cin.getline(key, 30000);
    ciphering(plain, strlen(plain), key, strlen(key));
}
int main()
{
    test();
    return 0;
}
