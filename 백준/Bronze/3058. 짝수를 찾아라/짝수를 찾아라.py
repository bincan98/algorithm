"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

for _ in range(int(input())):
    lst = list(map(int, input().split()))
    total = 0
    min_value = 102
    for a in lst:
        if a % 2 == 0:
            total += a
            min_value = min(min_value, a)
    print(total, min_value)