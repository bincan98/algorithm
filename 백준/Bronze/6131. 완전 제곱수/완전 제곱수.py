"""
완전탐색
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

answer = 0
for a in range(1, 501):
	for b in range(1, a):
		if int(a ** 2) - int(b ** 2) == N:
			answer += 1

print(answer)