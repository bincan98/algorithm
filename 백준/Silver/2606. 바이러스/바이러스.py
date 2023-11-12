"""
dfs로 연결요소 체크
"""

import sys

input = lambda: sys.stdin.readline().strip()
answer = 0


def dfs(current):
    global answer
    answer += 1
    visited[current] = True

    for nxt in lst[current]:
        if not visited[nxt]:
            dfs(nxt)


N = int(input())
M = int(input())

lst = [[] for _ in range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)

visited = [False] * (N+1)
dfs(1)
print(answer - 1)