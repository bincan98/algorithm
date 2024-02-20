"""
구현

bfs

동쪽이 1, 서쪽이 2, 남쪽이 3, 북쪽이 4을
북쪽 0 동쪽 1 남쪽 2 서쪽 3으로 수정해서 받기
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

dxy = [[-1, 0], [0, 1], [1, 0], [0, -1]]

M, N = map(int, input().split())
lst = []
for _ in range(M):
    lst.append(list(map(int, input().split())))


def change_dir(x):
    if x == 4:
        return 0
    elif x == 2:
        return 3
    elif x == 3:
        return 2
    else:
        return 1


start_y, start_x, start_dir = map(int, input().split())
target_y, target_x, target_dir = map(int, input().split())

start_y -= 1
start_x -= 1
target_y -= 1
target_x -= 1
start_dir = change_dir(start_dir)
target_dir = change_dir(target_dir)
q = deque()
visited = [[[20_000 for _ in range(4)] for _ in range(N)] for _ in range(M)]

visited[start_y][start_x][start_dir] = 0
q.append((start_y, start_x, start_dir, 0))

answer = 0
while q:
    cur_y, cur_x, cur_dir, cnt = q.popleft()
    for i in range(1, 4):
        ny = cur_y + i * dxy[cur_dir][0]
        nx = cur_x + i * dxy[cur_dir][1]
        if 0 <= ny < M and 0 <= nx < N:
            if lst[ny][nx] == 1:
                break
            else:
                if visited[ny][nx][cur_dir] > cnt + 1:
                    visited[ny][nx][cur_dir] = cnt + 1
                    q.append((ny, nx, cur_dir, cnt + 1))
    for i in [1, 3]:
        n_dir = (cur_dir + i) % 4
        if visited[cur_y][cur_x][n_dir] > cnt + 1:
            visited[cur_y][cur_x][n_dir] = cnt + 1
            q.append((cur_y, cur_x, n_dir, cnt + 1))

print(visited[target_y][target_x][target_dir])