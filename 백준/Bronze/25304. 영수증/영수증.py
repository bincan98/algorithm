"""

"""

import sys

input = lambda: sys.stdin.readline().strip()

total = int(input())

N = int(input())
result = 0
for i in range(N):
    a, b = map(int, input().split())
    result += a * b

if result == total:
    print("Yes")
else:
    print("No")