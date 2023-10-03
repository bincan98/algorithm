"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

A, B = map(int, input().split())

if A <= B:
    print(A + A - 1)
elif A > B:
    print(B + B + 1)