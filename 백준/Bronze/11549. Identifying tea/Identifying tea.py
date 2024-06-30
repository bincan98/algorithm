"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

answer = int(input())

result = 0
for a in list(map(int, input().split())):
    if a == answer:
        result += 1

print(result)