import sys

input = lambda: sys.stdin.readline().strip()

L, P = map(int, input().split())
lst = list(map(int, input().split()))

for a in lst:
    print(a - (L * P), end=" ")