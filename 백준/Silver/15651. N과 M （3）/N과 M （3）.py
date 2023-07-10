"""
중복순열 기본코드
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

selected = [0] * M


def recur(cur):
	if cur == M:
		print(*selected)
		return
	for i in range(1, N+1):
		selected[cur] = i
		recur(cur + 1)


recur(0)