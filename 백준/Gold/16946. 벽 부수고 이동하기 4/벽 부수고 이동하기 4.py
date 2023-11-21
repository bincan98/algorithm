"""
2차원 배열 돌면서
0인 곳들 연결요소 개수 찾기
나중에 헷갈리면 안되니까 cnt도 넣어주기
"""
import sys
from collections import deque
from collections import defaultdict


def bfs(start_y, start_x, idx):
    q = deque()

    visited[start_y][start_x] = True
    q.append([start_y, start_x])
    dist[start_y][start_x] = idx

    cnt = 1
    while q:
        cur_y, cur_x = q.popleft()
        for dy, dx in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
            ny = cur_y + dy
            nx = cur_x + dx
            if 0 <= ny < n and 0 <= nx < m:
                if not visited[ny][nx]:
                    if board[ny][nx] == 0:
                        q.append([ny, nx])
                        visited[ny][nx] = True
                        dist[ny][nx] = idx
                        cnt += 1
    dic[idx] = cnt


input = lambda: sys.stdin.readline().strip()

n, m = map(int, input().split())
board = [list(map(int, input())) for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]
dist = [[-1 for _ in range(m)] for _ in range(n)]

dic = defaultdict(int)

idx = 0
for i in range(n):
    for j in range(m):
        if not visited[i][j]:
            if board[i][j] == 0:
                bfs(i, j, idx)
                idx += 1

for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            continue
        lst = []
        for dy, dx in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
            ny = i + dy
            nx = j + dx
            if 0 <= ny < n and 0 <= nx < m:
                if board[ny][nx] != 0:
                    continue
                if dist[ny][nx] not in lst:
                    lst.append(dist[ny][nx])
                    board[i][j] += dic[dist[ny][nx]]
                    board[i][j] %= 10

for i in range(n):
    for j in range(m):
        print(board[i][j], end="")
    print()