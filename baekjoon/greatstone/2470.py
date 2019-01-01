# 문제: https://www.acmicpc.net/problem/2470
# 풀이: 정렬 후 가장 작은 수와 가장 큰 수를 가리키는 인덱스를 만들어 이동하며 비교
#      두 인덱스가 가리키는 수의 합이 0보다 크면 오른쪽 인덱스를 감소하고 0보다 작으면 왼쪽 인덱스를 증가한다

from sys import stdin
n = int(stdin.readline())
solutions = list(map(int, stdin.readline().split()))
solutions.sort()
find = (solutions[0], solutions[-1], abs(solutions[0] + solutions[-1]))
left = 0
right = len(solutions) - 1
while left < right:
    sum = solutions[left] + solutions[right]
    if abs(sum) < find[2]:
        find = (solutions[left], solutions[right], abs(sum))
    if sum > 0:
        right -= 1
    else:
        left += 1
print(find[0], find[1])
