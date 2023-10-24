import sys
import math

input = lambda: sys.stdin.readline().strip()

N = int(input())

for i in range(N):
    for j in range(i):
        print(" ", end="")
    for j in range((N-i) * 2 - 1):
        print("*", end="")
    print()
for i in range(N-1):
    for j in range(N-2-i):
        print(" ", end="")
    for j in range((i+1) * 2 + 1):
        print("*", end="")
    print()