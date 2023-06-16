import sys

input = sys.stdin.readline

n = int(input())

for i in range(1, 1_000_000_000):
    if n <= 1:
        print(i)
        break
    n -= (6 * i)