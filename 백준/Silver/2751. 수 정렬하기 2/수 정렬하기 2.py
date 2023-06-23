"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = []

for i in range(N):
    lst.append(int(input()))

lst = sorted(lst)

for i in range(N):
    print(lst[i])