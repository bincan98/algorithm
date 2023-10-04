"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

cnt = 0
for i in range(1, N+1):
    for j in range(1, N+1):
        if i == j:
            continue
        cnt += 1

print(cnt)