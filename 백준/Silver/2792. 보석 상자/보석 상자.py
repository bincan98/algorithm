"""
질투심이 최소가 되게 나누어주는 방식은 모두 동일하게 나누기

만약 나누다가 보석이 남으면 그 수는 불가능한것 보석수 올리기

만약 남지 않으면 일단 저장하고 보석수 낮추기

보석 수 대신 나누어 두어야 하는 사람 수로 변경

나누어 주어야 하는 사람 수가 원래 아이들 수보다 많으면 보석 늘리기

적으면 일단 저장하고 보석 줄이기
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())
lst = []
for _ in range(M):
    lst.append(int(input()))

answer = max(lst)
start = 1
end = max(lst)
while start <= end:
    mid = (start + end) // 2
    cnt_child = 0
    for gem in lst:
        if gem % mid == 0:
            cnt_child += gem // mid
        else:
            cnt_child += gem // mid + 1
    if cnt_child > N:
        start = mid + 1
    else:
        answer = min(answer, mid)
        end = mid - 1

print(answer)