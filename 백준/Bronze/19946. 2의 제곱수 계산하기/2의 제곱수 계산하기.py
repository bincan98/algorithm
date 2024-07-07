"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

K = 64

for i in range(K, 0, -1):
    if N % 2 == 1:
        print(i)
        break
    else:
        N //= 2