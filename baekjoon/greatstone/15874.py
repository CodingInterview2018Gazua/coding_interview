# 문제: https://www.acmicpc.net/problem/15874
# 풀이: 루프 돌면서 character를 순환 이동 시켜 출력

k, s_len = map(int, input().split())
s = input()

ord_a = ord('a')
ord_A = ord('A')
result = ""
for c in s:
    if c.isalpha():
        if c.isupper():
            result += chr((ord(c) - ord_A + k) % 26 + ord_A)
        else:
            result += chr((ord(c) - ord_a + k) % 26 + ord_a)
    else:
        result += c
print(result)
