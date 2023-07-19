"""
완전탐색
"""

import sys

input = lambda: sys.stdin.readline().strip()

lst = [int(input()) for _ in range(10)]

answer = 0
sum = 0
sub = 100
for i in range(10):
    sum += lst[i]
    if sub >= abs(100 - sum):
        answer = sum
        sub = abs(100 - sum)

print(answer)