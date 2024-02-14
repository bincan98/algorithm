"""
트리로 연결이면 연결요소의 개수 구하기

연산횟수 = 연결요소 개수 - 1

그런데 사이클이 있다면?

연산횟수 = 연결요소 개수 - 1 + 사이클 개수
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

edge = [[] for _ in range(N + 1)]
visited = [False for _ in range(N + 1)]

for _ in range(M):
    u, v = map(int, input().split())
    edge[u].append(v)
    edge[v].append(u)


def bfs(start):
    cnt = 0
    q = deque()
    visited[start] = True
    q.append((start, -1))

    while q:
        cur, prev = q.popleft()
        for nxt in edge[cur]:
            if nxt == prev:
                continue
            if not visited[nxt]:
                visited[nxt] = True
                q.append((nxt, cur))
            else:
                cnt += 1
    return cnt // 2


cnt_component = 0
cnt_cycle = 0
for i in range(1, N + 1):
    if not visited[i]:
        cnt_component += 1
        cnt_cycle += bfs(i)

print(cnt_component - 1 + cnt_cycle)