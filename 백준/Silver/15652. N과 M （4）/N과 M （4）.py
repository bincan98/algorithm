"""
중복조합 기본코드
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

selected = [0] * M


def recur(cur, start):
	if cur == M:
		print(*selected)
		return
	for i in range(start, N+1):
		selected[cur] = i
		recur(cur + 1, i)


recur(0, 1)