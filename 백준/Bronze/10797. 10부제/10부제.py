"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))

answer = 0
for a in lst:
    if a == N:
        answer += 1

print(answer)