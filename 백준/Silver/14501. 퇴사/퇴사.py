"""
백트래킹
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]
answer = 0


def recur(cur, total):
	global answer

	# 하면 안되는 일
	if cur > N:
		return
	# 끝까지 도착한 경우 정답 갱신
	if cur == N:
		answer = max(answer, total)
		return
	# 이번 일을 하는 경우
	recur(cur + lst[cur][0], total + lst[cur][1])
	# 이번 일을 하지 않는 경우
	recur(cur + 1, total)


recur(0, 0)
print(answer)