"""
가능한 값을 찾는 매개변수탐색인데 선형태를 띠므로 이분탐색이 가능하다

가능한 최대값부터 이분탐색으로 좁혀보되

deque를 이요해 가능한지 검증하기
"""
import sys
import math
from collections import deque

input = lambda: sys.stdin.readline().strip()


def valid(r):
    x = min(lst) + r
    left_end = min(lst)
    right_end = min(lst) + (2 * r)
    q = deque(lst)
    cnt = 1
    while cnt <= K:
        while q:
            if left_end <= q[0] <= right_end:
                q.popleft()
            else:
                break
        if not q:
            break
        cnt += 1
        left_end = min(q)
        right_end = min(q) + (2 * r)
    if q:
        return False
    else:
        return True


N, K = map(int, input().split())

lst = []
for i in range(N):
    lst.append(int(input()))

lst = sorted(lst)

start = 0
end = math.ceil((max(lst) - min(lst)) / 2)
answer = end
while start <= end:
    mid = (start + end) // 2
    is_possible = valid(mid)
    if is_possible:
        answer = mid
        end = mid - 1
    else:
        start = mid + 1

print(answer)