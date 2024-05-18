"""
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

N_truth, *truth = map(int, input().split())

know = [False] * (N + 1)
for t in truth:
    know[t] = True

party = [[] for _ in range(M)]
graph = [[] for _ in range(N + 1)]
for i in range(M):
    b, *lst = map(int, input().split())
    party[i] = lst[:]
    for j in range(b):
        for k in range(j + 1, b):
            graph[party[i][j]].append(party[i][k])
            graph[party[i][k]].append(party[i][j])

def bfs(start):
    q = deque()
    visited = [False] * (N + 1)

    q.append(start)
    visited[start] = True

    while q:
        cur = q.popleft()
        for vertex in graph[cur]:
            if not visited[vertex]:
                q.append(vertex)
                visited[vertex] = True
                know[vertex] = True

for t in truth:
    bfs(t)

answer = 0
for lst in party:
    possible = True
    for a in lst:
        if know[a]:
            possible = False
            break
    if possible:
        answer += 1

print(answer)