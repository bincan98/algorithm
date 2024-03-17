"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, T, C, P = map(int, input().split())

cnt = 0
cur = T + 1
while cur <= N:
    cnt += 1
    cur += T

print(cnt * C * P)