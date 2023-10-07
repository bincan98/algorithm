"""

"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))

lst = sorted(lst)

print(lst[(N+1)//2-1])