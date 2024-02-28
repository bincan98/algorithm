"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

S = int(input())

sum_value = 0
answer = 0
for i in range(1, 100_000):
    sum_value += i
    if sum_value > S:
        answer = i - 1
        break

print(answer)