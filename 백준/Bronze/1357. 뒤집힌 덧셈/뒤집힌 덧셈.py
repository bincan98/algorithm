"""
"""

import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

X, Y = map(int, input().split())


def rev(a):
    result = 0
    ls = []
    while a:
        ls.append(a % 10)
        a //= 10
    for i in range(0, len(ls)):
        result *= 10
        result += ls[i]
    return result


print(rev(rev(X) + rev(Y)))