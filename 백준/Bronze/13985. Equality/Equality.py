"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = list(input().split())

if int(lst[0]) + int(lst[2]) == int(lst[4]):
    print("YES")
else:
    print("NO")