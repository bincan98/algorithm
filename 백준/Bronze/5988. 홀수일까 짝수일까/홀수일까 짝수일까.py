"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
for i in range(N):
    s = int(input())
    if s % 2 == 0:
        print("even")
    else:
        print("odd")