"""
그냥 하면 안되나?

"""

import sys

input = lambda: sys.stdin.readline().strip()

MOD = 10_000_000

N = int(input())

check = [0] * (2 * MOD+1)

lst = list(map(int, input().split()))
for ele in lst:
    check[ele + MOD] += 1

M = int(input())
lst = list(map(int, input().split()))
for ele in lst:
    if check[ele + MOD] > 0:
        print(check[ele + MOD], end=' ')
    else:
        print(0, end=' ')