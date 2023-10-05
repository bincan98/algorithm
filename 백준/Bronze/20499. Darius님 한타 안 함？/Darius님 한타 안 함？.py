"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

K, D, A = map(int, input().split("/"))

if D == 0 or K + A < D:
    print("hasu")
else:
    print("gosu")