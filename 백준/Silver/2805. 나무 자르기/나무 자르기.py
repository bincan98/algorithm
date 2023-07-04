"""
답의 형태가 연속적인 매개변수 탐색이다
따라서 이분탐색의 형태로 변경할 수 있다
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

lst = list(map(int, input().split()))

answer = 0

start = 0
end = max(lst)
while start <= end:
    result = 0
    mid = (start + end) // 2
    for ele in lst:
        if ele - mid > 0:
            result += ele - mid
    if result >= M:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)