"""

"""

import sys

input = lambda: sys.stdin.readline().strip()

s = int(input())

total = 0
while s != -1:
    total += s
    s = int(input())

print(total)