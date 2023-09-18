"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())
ls1 = []
for i in range(N):
    ls1.append(list(map(int, input().split())))

ls2 = []
for i in range(N):
    ls2.append(list(map(int, input().split())))

for i in range(N):
    for j in range(M):
        ls1[i][j] += ls2[i][j]

for i in range(N):
    print(*ls1[i])