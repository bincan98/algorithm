"""
완전탐색

그냥 냅다 돌리기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, K, A, B = map(int, input().split())

lst = [K] * N

idx = 0
day = 0
con = True
while con:
    day += 1
    for i in range(idx, idx + A):
        lst[i % N] += B
    for i in range(N):
        lst[i] -= 1
        if lst[i] <= 0:
            con = False
    idx = idx + A % N

print(day)