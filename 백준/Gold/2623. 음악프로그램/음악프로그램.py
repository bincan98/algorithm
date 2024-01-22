"""
위상 정렬

answer에 원소가 하나라도 없다면 불가능한 경우
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()


N, M = map(int, input().split())

in_degree = [0] * (N+1)
graph = [[] for _ in range(N+1)]

for i in range(M):
    a, *lst = map(int, input().split())
    for j in range(a-1):
        graph[lst[j]].append(lst[j+1])
        in_degree[lst[j+1]] += 1

answer = []
q = deque()

for i in range(1, N+1):
    if in_degree[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    answer.append(cur)

    for nxt in graph[cur]:
        in_degree[nxt] -= 1
        if in_degree[nxt] == 0:
            q.append(nxt)

if len(answer) == N:
    for a in answer:
        print(a)
else:
    print(0)