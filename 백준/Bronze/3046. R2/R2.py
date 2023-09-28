"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

a, b = map(int, input().split())
print(b * 2 - a)