"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, X = map(int, input().split())
A = list(map(int, input().split()))

mi = A[0] + A[1]
for i in range(N - 1):
    mi = min(mi, A[i + 1] + A[i])

print(mi * X)