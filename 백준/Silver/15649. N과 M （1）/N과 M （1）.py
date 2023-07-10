"""
순열 기본코드
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

selected = [0] * M
visited = [False] * (N+1)


def recur(cur):
	if cur == M:
		print(*selected)
		return
	for i in range(1, N+1):
		if visited[i]:
			continue
		selected[cur] = i
		visited[i] = True
		recur(cur + 1)
		visited[i] = False


recur(0)
