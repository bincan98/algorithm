"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

total = 0
min_value = 999
for i in range(7):
    N = int(input())

    if N % 2 == 1:
        total += N
        if N < min_value:
            min_value = N

if total == 0:
    print(-1)
else:
    print(total)
    print(min_value)