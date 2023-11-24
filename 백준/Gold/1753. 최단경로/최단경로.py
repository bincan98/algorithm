"""
다익스트라
"""
import sys
import heapq

input = lambda: sys.stdin.readline().strip()

V, E = map(int, input().split())
K = int(input())

lst = [[] for _ in range(V + 1)]
dist = [987654321] * (V + 1)

for i in range(E):
    a, b, c = map(int, input().split())
    lst[a].append([b, c])


def daijkstra(start):
    pq = []
    heapq.heapify(pq)

    dist[start] = 0
    pq.append([dist[start], start])

    while pq:
        dis, v = heapq.heappop(pq)
        if dist[v] != dis:
            continue
        for vertex in lst[v]:
            if dist[vertex[0]] > dist[v] + vertex[1]:
                dist[vertex[0]] = dist[v] + vertex[1]
                heapq.heappush(pq, [dist[vertex[0]], vertex[0]])


daijkstra(K)

for i in range(1, V + 1):
    if i == K:
        print(0)
        continue
    if dist[i] == 987654321:
        print("INF")
    else:
        print(dist[i])