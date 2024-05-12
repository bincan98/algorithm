"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

s = input()

answer = 0
for a in s:
    if a in ['a', 'e', 'i', 'o', 'u']:
        answer += 1

print(answer)