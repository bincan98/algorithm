"""
중복순열 기본코드
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())
lst = list(map(int, input().split()))

lst = sorted(lst)

selected = [0] * M


def recur(cur):
	if cur == M:
		for i in selected:
			print(lst[i], end=" ")
		print()
		return
	for i in range(N):
		selected[cur] = i
		recur(cur + 1)


recur(0)