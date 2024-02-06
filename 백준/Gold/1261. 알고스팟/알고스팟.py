"""
다익스트라
"""
import sys
import heapq

input = lambda: sys.stdin.readline().strip()

M, N = map(int, input().split())

edge = [[[] for _ in range(M)] for _ in range(N)]
dis = [[987654321 for _ in range(M)] for _ in range(N)]

lst = []
for _ in range(N):
    lst.append(list(map(int, input())))

for i in range(N):
    for j in range(M):
        for dy, dx in [[0, -1], [-1, 0], [0, 1], [1, 0]]:
            ny = i + dy
            nx = j + dx
            if 0 <= ny < N and 0 <= nx < M:
                w = -1
                if lst[ny][nx] == 0:
                    w = 0
                else:
                    w = 1
                edge[i][j].append([ny, nx, w])


def dijkstra(start_y, start_x):
    pq = []
    dis[start_y][start_x] = 0
    heapq.heappush(pq, [0, start_y, start_x])

    while pq:
        distance, cur_y, cur_x = heapq.heappop(pq)
        if dis[cur_y][cur_x] != distance:
            continue
        for nxt_y, nxt_x, w in edge[cur_y][cur_x]:
            if dis[nxt_y][nxt_x] > dis[cur_y][cur_x] + w:
                dis[nxt_y][nxt_x] = dis[cur_y][cur_x] + w
                heapq.heappush(pq, [dis[nxt_y][nxt_x], nxt_y, nxt_x])


dijkstra(0, 0)

print(dis[N-1][M-1])