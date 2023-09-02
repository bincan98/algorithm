import sys

input = lambda: sys.stdin.readline().strip()

N, X = map(int, input().split())

print(abs(N-X))