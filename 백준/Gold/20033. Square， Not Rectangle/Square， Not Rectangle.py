"""
하나하나 해봐야하지만 그럼 O(N^2)

이분탐색으로 시간복잡도를 줄이자
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))

answer = 0

start = 1
end = N
while start <= end:
    is_possible = False
    cnt = 0
    mid = (start + end) // 2
    for num in lst:
        if num - mid >= 0:
            cnt += 1
        else:
            cnt = 0
        if cnt == mid:
            is_possible = True
            break
    if is_possible:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)