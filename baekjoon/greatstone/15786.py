# 문제: https://www.acmicpc.net/problem/15786
# 풀이: 루프 돌며 알고 있는 단어의 문자들이 순서대로 위치한 단어인지 확인

n, m = map(int, input().split())
original = input()
post_it = [input() for _ in range(m)]

for s in post_it:
    org_idx = 0
    for c in s:
        if original[org_idx] == c:
            org_idx += 1
        if org_idx >= n:
            print("true")
            break
    else:
        print("false")
