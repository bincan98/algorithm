"""
dfs + dp
"""
import sys

dxy = [[0, 1], [1, 0], [0, -1], [-1, 0]]

input = lambda: sys.stdin.readline().strip()


def dfs(cur_y, cur_x):

    if cur_y == M-1 and cur_x == N-1:
        return 1
    if dist[cur_y][cur_x] != -1:
        return dist[cur_y][cur_x]

    cnt = 0
    for dy, dx in dxy:
        ny = cur_y + dy
        nx = cur_x + dx
        if 0 <= ny < M and 0 <= nx < N and lst[cur_y][cur_x] > lst[ny][nx]:
            cnt += dfs(ny, nx)

    dist[cur_y][cur_x] = cnt
    return dist[cur_y][cur_x]

M, N = map(int, input().split())
lst = []
dist = [[-1] * N for _ in range(M)]
for i in range(M):
    lst.append(list(map(int, input().split())))

answer = 0
dfs(0, 0)
# print(answer)
print(dist[0][0])
# for i in range(M):
#     print(*dist[i])