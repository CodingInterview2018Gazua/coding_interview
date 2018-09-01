# !/usr/bin/python
# -*- coding: utf-8 -*-

"""
https://www.acmicpc.net/problem/2954
"""


def revert_diary(words):
    vowels = 'aeiou'
    vowels_patterns = [''.join([vowel, 'p', vowel]) for vowel in vowels]

    for i in range(len(vowels_patterns)):
        words = words.replace(vowels_patterns[i], vowels_patterns[i][:1])

    return words


# int main() {
#     string s;
#     const char a = 'a';
#     int mask = 1 << ('a' - a) |
#                1 << ('e' - a) |
#                1 << ('i' - a) |
#                1 << ('o' - a) |
#                1 << ('u' - a);
#     getline(cin, s);
#     int len = s.size();
#     for (int i=0; i<len; ++i) {
#         cout << s[i];
#         if ((1 << (s[i] - a)) & mask) {
#             i+=2;
#         }
#     }
#     return 0;
# }

words = 'zepelepenapa'

alphabet_a = ord('a')
mask = 1 << (ord('a')) - alphabet_a or \
       1 << (ord('e')) - alphabet_a or \
       1 << (ord('i')) - alphabet_a or \
       1 << (ord('o')) - alphabet_a or \
       1 << (ord('u')) - alphabet_a
print mask

for i in range(len(list(words))):
    print words[i]
    if 1 << (ord(words[i]) - ord('a')) & mask:
        i += 2


print revert_diary('zepelepenapa')
# words = raw_input('').strip()
# words = words.split(' ')
# result = []
# for i in range(len(words)):
#     result.append(revert_diary(words[i]))
#
# print ' '.join(result)

