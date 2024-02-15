"""
완탐?
n이 100_000 2^100_000

그리디
가장 빨리 끝나는 회의를 우선으로 잡자
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = []
for _ in range(N):
    a, b = map(int, input().split())
    lst.append([b, a])

lst = sorted(lst)

end_time = -1
answer = 0
for e, s in lst:
    if s >= end_time:
        answer += 1
        end_time = e

print(answer)