"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

sum_value = 0
for i in range(5):
    sum_value += int(input())

print(sum_value)