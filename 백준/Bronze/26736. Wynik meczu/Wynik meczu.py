
"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

s = list(input())

answer_a = 0
answer_b = 0
for a in s:
    if a == 'A':
        answer_a += 1
    else:
        answer_b += 1

print(f'{answer_a} : {answer_b}')