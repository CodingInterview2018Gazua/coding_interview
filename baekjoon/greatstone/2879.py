# 문제: https://www.acmicpc.net/problem/2879
# 풀이: 1. 현재 탭과 고칠 탭의 차 배열을 계산
#      2. 루프를 돌며 시작점부터 차이가 값이 0이 아닌 위치까지 한 그룹으로 탭을 넣거나(+1) 탭을 뺀다(-1)
#      3. 한 그룹에 탭을 넣거나 빼면 카운트 증가

n = int(input())
current_tabs = list(map(int, input().split()))
result_tabs = list(map(int, input().split()))
differences = [current_tabs[i] - result_tabs[i] for i in range(n)]

count = 0
i = 0
while i < n:
    if differences[i] != 0:
        if differences[i] > 0:
            group = i
            while group < n and differences[group] > 0:
                differences[group] -= 1
                group += 1
        else:
            group = i
            while group < n and differences[group] < 0:
                differences[group] += 1
                group += 1
        count += 1
    else:
        i += 1
print(count)
