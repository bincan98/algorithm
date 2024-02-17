import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

for p in range(2, int(N ** 0.5) + 1):
    while N % p == 0:
        print(p)
        N = N // p
    if N == 1:
        break
if N != 1:
    print(N)