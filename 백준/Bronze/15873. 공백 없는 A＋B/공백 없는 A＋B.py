"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

a = list(map(int, input()))

if len(a) == 2:
    print(a[0] + a[1])
elif len(a) == 4:
    print(a[0] * 10 + a[1] + a[2] * 10 + a[3])
else:
    if a[1] == 0:
        print(a[0] * 10 + a[1] + a[2])
    else:
        print(a[0] + a[1] * 10 + a[2])