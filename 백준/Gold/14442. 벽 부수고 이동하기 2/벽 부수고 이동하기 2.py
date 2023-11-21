"""
dist 를 visited로 사용하기

3차원으로 선언해서 벽을 부셨을때와 아닐떄를 구별
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

n, m, k = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(n)]
dist = [[[-1 for _ in range(k + 1)] for _ in range(m)] for _ in range(n)]

q = deque()
# x, y, 부신 벽
q.append((0, 0, 0))
dist[0][0][0] = 1

while q:
    x, y, destroy = q.popleft()
    if x == n-1 and y == m-1:
        break
    for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
        nx, ny = x + dx, y + dy
        if nx < 0 or ny < 0 or nx > n - 1 or ny > m - 1:
            continue
        if board[nx][ny] == 1:
            if destroy < k:
                if dist[nx][ny][destroy + 1] == -1:
                    q.append((nx, ny, destroy + 1))
                    dist[nx][ny][destroy + 1] = dist[x][y][destroy] + 1
        else:
            if dist[nx][ny][destroy] == -1:
                q.append((nx, ny, destroy))
                dist[nx][ny][destroy] = dist[x][y][destroy] + 1

answer = 987654321
for i in range(k + 1):
    if dist[n-1][m-1][i] == -1:
        continue
    answer = min(answer, dist[n-1][m-1][i])

if answer == 987654321:
    print(-1)
else:
    print(answer)