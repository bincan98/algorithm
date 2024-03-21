"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, A, B, C, D = map(int, input().split())

answer = 0

if N % A == 0:
    answer = B * (N // A)
else:
    answer = B * (N // A + 1)

if N % C == 0:
    answer = min(answer, D * (N // C))
else:
    answer = min(answer, D * (N // C + 1))

print(answer)