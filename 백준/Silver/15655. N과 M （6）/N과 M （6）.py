"""
조합 기본코드
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())
lst = list(map(int, input().split()))

lst = sorted(lst)

selected = [0] * M


def recur(cur, start):
	if cur == M:
		for i in selected:
			print(lst[i], end=" ")
		print()
		return
	for i in range(start, N):
		selected[cur] = i
		recur(cur + 1, i + 1)


recur(0, 0)