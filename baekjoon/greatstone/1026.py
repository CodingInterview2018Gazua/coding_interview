# 문제: https://www.acmicpc.net/problem/1026
# 풀이: 문제에서 B는 재배열하면 안된다고 했지만 S의 최솟값을 출력하는 프로그램이니 A는 ascending으로 B는 Descending으로 정렬하여 S를 계산하여 출력한다.

n = int(input())
a = sorted(list(map(int, input().split())))
b = sorted(map(int, input().split()), reverse=True)
print(sum([a[i] * b[i] for i in range(n)]))
