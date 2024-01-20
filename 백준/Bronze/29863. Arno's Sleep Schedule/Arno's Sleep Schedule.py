import sys

input = lambda: sys.stdin.readline().strip()

A = int(input())
B = int(input())
if A > 12:
    print(B - (A - 24))
else:
    print(B - A)