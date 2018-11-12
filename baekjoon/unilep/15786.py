N, M = map(int, input().split())
S = input()
postits = list()
for _ in range(M):
    s = input()
    idx = 0
    f = False
    for i in range(len(s)):
        if idx == len(S):
            f = True
            break
        if S[idx] == s[i]:
            idx += 1
    if idx == len(S):
        f = True
    print("true" if f is True else "false")
