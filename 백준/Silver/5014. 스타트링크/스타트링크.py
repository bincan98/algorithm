"""
BFS 를 쓰자

dist 배열을 만들어서 가능한 최소거리를 모두 채우고 그걸 출력하되, 초기값이라면
불가능한 경우이다


"""

import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

F, S, G, U, D = map(int, input().split())

dist = [-1] * (F + 1)
dx = [U, -D]


def is_valid(nxt):
    return 0 < nxt <= F


def bfs(start):
    q = deque()
    q.append(start)
    dist[start] = 0

    while q:
        cur = q.popleft()
        for i in dx:
            nxt = cur + i
            if is_valid(nxt) and dist[nxt] == -1:
                q.append(nxt)
                dist[nxt] = dist[cur] + 1


bfs(S)
if dist[G] == -1:
    print("use the stairs")
else:
    print(dist[G])