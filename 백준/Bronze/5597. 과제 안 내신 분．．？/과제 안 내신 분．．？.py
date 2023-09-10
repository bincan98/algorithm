"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

ls = [False] * 31

for i in range(28):
    ls[int(input())] = True

for i in range(1, 31):
    if not ls[i]:
        print(i)