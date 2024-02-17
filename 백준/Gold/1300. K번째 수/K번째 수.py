"""
이분탐색

7번째 위치에 뭐가 있냐가 아니라 특정 수가 7번째 위치에 있냐로 찾기

mid보다 작은 수들의 개수와 작거나 같은 수들의 개수로 위치를 찾기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
k = int(input())

answer = -1
s = 1
e = N * N
while True:
    mid = (s + e) // 2
    cnt_small_equal = 0
    cnt_small = 0
    for i in range(1, N+1):
        cnt_small_equal += min(N, mid // i)
        cnt_small += min(N, (mid-1) // i)
    if cnt_small < k <= cnt_small_equal:
        answer = mid
        break
    elif k <= cnt_small:
        e = mid - 1
    else:
        s = mid + 1

print(answer)