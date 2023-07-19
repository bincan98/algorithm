"""
완전 탐색
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

answer = 0
for a in range(1, 101): # 영훈이
	for b in range(a + 2, 101): # 남규
		for c in range(1, 101): # 택희
			if c % 2 != 0:
				continue
			if a + b + c == N:
				answer += 1

print(answer)