import sys

input = lambda: sys.stdin.readline().strip()

A = int(input())
B = int(input())
if A == B:
    print(0)
elif A < B:
    print(-1)
else:
    print(1)