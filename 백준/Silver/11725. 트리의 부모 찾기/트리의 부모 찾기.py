"""
bfs로 루트부터 보기

visited에 그전꺼 저장
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = [[] for _ in range(N+1)]
visited = [-1] * (N + 1)

for i in range(N-1):
    a, b = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)


def bfs(start):
    q = deque()

    q.append([start, -1])
    visited[start] = start

    while q:
        cur, pre = q.popleft()
        for nxt in lst[cur]:
            if visited[nxt] == -1:
                q.append([nxt, cur])
                visited[nxt] = cur


bfs(1)
for i in range(2, N+1):
    print(visited[i])