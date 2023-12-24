import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

for i in range(N):
    if 6 <= len(input()) <= 9:
        print("yes")
    else:
        print("no")