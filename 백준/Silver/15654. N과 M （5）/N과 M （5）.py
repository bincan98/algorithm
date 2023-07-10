"""
순열 기본코드
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())
lst = list(map(int, input().split()))

lst = sorted(lst)

selected = [0] * M
visited = [False] * N


def recur(cur):
	if cur == M:
		for i in selected:
			print(lst[i], end=" ")
		print()
		return
	for i in range(N):
		if visited[i]:
			continue
		visited[i] = True
		selected[cur] = i
		recur(cur + 1)
		visited[i] = False


recur(0)