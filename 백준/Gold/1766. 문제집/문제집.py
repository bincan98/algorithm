"""
위상 정렬
"""
import sys
import heapq

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

in_degree = [0] * (N+1)
graph = [[] for _ in range(N+1)]

for _ in range(M):
    A, B = map(int, input().split())
    in_degree[B] += 1
    graph[A].append(B)

answer = []
pq = []
for i in range(1, N+1):
    if in_degree[i] == 0:
        heapq.heappush(pq, i)

while pq:
    cur = heapq.heappop(pq)
    answer.append(cur)

    for nxt in graph[cur]:
        in_degree[nxt] -= 1
        if in_degree[nxt] == 0:
            heapq.heappush(pq, nxt)

for a in answer:
    print(a, end=" ")