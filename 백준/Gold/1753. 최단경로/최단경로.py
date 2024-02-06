"""
다익스트라
"""
import sys
import heapq

input = lambda: sys.stdin.readline().strip()

V, E = map(int, input().split())
K = int(input())

lst = [[] for _ in range(V + 1)]
dis = [987654321 for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, input().split())
    lst[u].append([v, w])


def dijkstra(start):
    pq = []
    dis[start] = 0
    heapq.heappush(pq, [0, start])

    while pq:
        distance, cur_v = heapq.heappop(pq)
        if dis[cur_v] != distance:
            continue
        for v, w in lst[cur_v]:
            if dis[v] > dis[cur_v] + w:
                dis[v] = dis[cur_v] + w
                heapq.heappush(pq, [dis[v], v])


dijkstra(K)

for a in dis[1:]:
    if a == 987654321:
        print("INF")
    else:
        print(a)