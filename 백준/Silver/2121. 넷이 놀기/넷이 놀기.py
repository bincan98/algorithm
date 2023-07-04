"""
어떤 점의 좌표가 (x, y)일떄

점들의 리스트 중에

(x + A, y),
(x, y + B),
(x + A, y + B)
인 점이 있는지 확인하기

다만 하나의 점당 3번이나 확인해야하므로 오래걸린다 
따라서 이분탐색으로 시간을 줄이기
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

A, B = map(int, input().split())

lst = []
for _ in range(N):
    lst.append(list(map(int, input().split())))

lst = sorted(lst)


def binarySearch(targetX, targetY):
    isFind = False
    start = 0
    end = N-1
    while start <= end:
        mid = (start + end) // 2
        if lst[mid][0] > targetX:
            end = mid - 1
        elif lst[mid][0] < targetX:
            start = mid + 1
        else:
            if lst[mid][1] > targetY:
                end = mid - 1
            elif lst[mid][1] < targetY:
                start = mid + 1
            else:
                isFind = True
                break
    return isFind


answer = 0
for x, y in lst:
    if binarySearch(x + A, y) and binarySearch(x, y + B) and binarySearch(x + A, y + B):
        answer += 1

print(answer)