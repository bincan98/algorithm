"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = list(map(int, input().split()))

lst = sorted(lst)

if lst[0] == lst[1] == lst[2]:
    print(lst[0] * 1000 + 10000)
elif lst[0] == lst[1] or lst[1] == lst[2]:
    print(lst[1] * 100 + 1000)
else:
    print(lst[2] * 100)