"""
완전탐색
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())

cnt = 0
find = False
for i in range(1, N+1):
    if N % i == 0:
        cnt += 1
        if cnt == K:
            print(i)
            find = True

if not find:
    print(0)