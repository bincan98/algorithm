"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

answer = 1
for _ in range(N):
    a, b = map(int, input().split())
    if a == answer:
        answer = b
    elif b == answer:
        answer = a

print(answer)