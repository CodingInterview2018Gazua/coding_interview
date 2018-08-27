# /usr/bin/python
# -*- coding: utf-8 -*-

# 3.4 하노이탑 문제에는 3개의 탑과 N개의 원판이 등장하는데 각 원판은 어느 탑으로도 옮길 수 있다
# 하노이 탑 퍼즐은 세 개의 탑 가운데 하나에 이 N개의 원판을 쌓아두고 시작한다
# 이때 원판들은 지름이 작은 원판이 위쪽에 오도록 배열된다. 하노이 탑 퍼즐에는 다음과 같은 제약조건들이 있다


def hanoi(n, start, by, dest):
    if n == 1:
        print '{} -> {}'.format(start, dest)
    else:
        hanoi(n-1, start, dest, by)
        hanoi(1, start, by, dest)
        hanoi(n-1, by, start, dest)


tray_num = 3
hanoi(tray_num, 'A', 'B', 'C')