"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())

if n > 7:
    print(n - 7)
else:
    if n - 14 + 31 == m:
        print(n - 7 + 31)
    elif n - 14 + 30 == m:
        print(n - 7 + 30)
    elif n - 14 + 29 == m:
        print(n - 7 + 29)
    elif n - 14 + 28 == m:
        print(n - 7 + 28)