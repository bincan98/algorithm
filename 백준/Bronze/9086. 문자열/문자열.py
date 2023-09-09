"""
"""

import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

T = int(input())

for i in range(T):
    s = input()
    print(s[0] + s[-1])