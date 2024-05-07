"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

answer = 0
for i in range(N):
    result = 0
    for s in input():
        if s == "O":
            result += 1
    if result > M // 2:
        answer += 1

print(answer)