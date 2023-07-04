"""
그냥 하면 안되나?

"""

import sys

input = lambda: sys.stdin.readline().strip()

MOD = 10_000_000

N = int(input())

check = [False] * (2 * MOD+1)

lst = list(map(int, input().split()))
for ele in lst:
    check[ele + MOD] = True

M = int(input())
lst = list(map(int, input().split()))
for ele in lst:
    if check[ele + MOD]:
        print(1, end=' ')
    else:
        print(0, end=' ')