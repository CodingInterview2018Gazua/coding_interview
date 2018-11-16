# 문제: https://www.acmicpc.net/problem/13904
# 풀이: greedy algorithm. 
#      점수가 큰 과제부터 선택한다.
#      과제를 선택할 때는 마감일까지 끝낼 수 있는지를 확인한다.
#      set을 이용해 이미 해야 하는 과제가 있는 날을 저장하며
#      선택한 과제는 마감일부터 1일씩 당기며 set에 들어갈 수 있다면 
#      마감일 전에 끝낼 수 있다고 판단한다.

n = int(input())
dw_list = [list(map(int, input().split())) for _ in range(n)]
dw_list.sort(key=lambda x: x[1], reverse=True)
dic = set()
sum = 0
for dw in dw_list:
    d, w = dw
    while d > 0:
        if not d in dic:
            dic.add(d)
            sum += w
            break
        d -= 1
print(sum)
