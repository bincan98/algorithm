import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

for i in range(1, N+1):
    for j in range(N-i):
        print(" ", end="")
    for j in range(2*i-1):
        print("*", end="")
    print()