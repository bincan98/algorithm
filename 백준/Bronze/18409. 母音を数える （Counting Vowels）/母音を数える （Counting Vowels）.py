"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
S = input()

lst = ['a', 'i', 'u', 'e', 'o']
answer = 0
for a in S:
    if a in lst:
        answer += 1

print(answer)