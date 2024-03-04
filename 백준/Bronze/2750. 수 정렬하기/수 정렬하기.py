"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst= []
for i in range(int(input())):
    lst.append(int(input()))

lst = sorted(lst)

for a in lst:
    print(a)