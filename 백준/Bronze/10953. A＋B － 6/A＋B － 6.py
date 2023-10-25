import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

for i in range(N):
    a, b = map(int, input().split(","))
    print(a + b)