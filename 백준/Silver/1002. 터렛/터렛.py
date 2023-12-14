"""
원의 방정식

두 원점과 반지름의 관계로 구하기
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

for i in range(N):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    if r2 > r1:
        tmp = r1
        r1 = r2
        r2 = tmp
        tmp = x1
        x1 = x2
        x2 = tmp
        tmp = y1
        y1 = y2
        y2 = tmp

    if x1 == x2 and y1 == y2 and r1 == r2:
        print(-1)
        continue

    distance = (int((x1 - x2) ** 2) + int((y1 - y2) ** 2)) ** 0.5

    if distance > r1:
        # 원 밖에 있음
        if distance == r1 + r2:
            print(1)
        elif distance > r1 + r2:
            print(0)
        else:
            print(2)
    elif distance == r1:
        # 원 위에 있는 경우
        print(2)
    else:
        # 원 안에 있는 경우
        if distance + r2 == r1:
            print(1)
        elif distance + r2 > r1:
            print(2)
        else:
            print(0)