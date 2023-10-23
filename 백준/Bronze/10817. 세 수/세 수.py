"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

lst = list(map(int, input().split()))

print(sorted(lst)[1])