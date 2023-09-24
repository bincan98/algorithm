"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

while N != 0:
    result = 0
    for i in range(1, N+1):
        result += i
    print(result)
    N = int(input())