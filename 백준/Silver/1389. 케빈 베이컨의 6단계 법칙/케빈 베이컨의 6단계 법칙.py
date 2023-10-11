"""
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()


def bfs(start):
    dist = [-1] * (N+1)
    q = deque()

    dist[start] = 0
    q.append(start)

    while q:
        cur = q.popleft()
        for nxt in lst[cur]:
            if dist[nxt] == -1:
                dist[nxt] = dist[cur] + 1
                q.append(nxt)

    total = 0
    for i in range(1, N+1):
        total += dist[i]

    result[start] = total


N, M = map(int, input().split())
lst = [[] for i in range(N + 1)]

for i in range(M):
    a, b = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)

result = [-1] * (N + 1)
for i in range(1, N+1):
    bfs(i)

answer = 1
answer_value = result[1]
for i in range(1, N+1):
    if answer_value > result[i]:
        answer = i
        answer_value = result[i]

print(answer)