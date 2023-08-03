"""
그래프

bfs
"""

import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

dxy = [[0, 1], [1, 0], [0, -1], [-1, 0]]

n, m = map(int, input().split())

lst = []
for i in range(n):
    lst.append(list(map(int, input())))

dist = [[-1] * m for _ in range(n)]


def is_valid(ny, nx):
    return 0 <= ny < n and 0 <= nx < m


def bfs(start_y, start_x):
    result = -1
    complete = False
    q = deque()
    q.append((start_y, start_x))

    dist[start_y][start_x] = 0

    while q:
        cur_y, cur_x = q.popleft()
        for i in range(4):
            ny = cur_y + dxy[i][0]
            nx = cur_x + dxy[i][1]
            if is_valid(ny, nx) and lst[ny][nx] != 1 and dist[ny][nx] == -1:
                if lst[ny][nx] == 0:
                    q.append((ny, nx))
                    dist[ny][nx] = dist[cur_y][cur_x] + 1
                else:
                    result = dist[cur_y][cur_x] + 1
                    complete = True
                    break
        if complete:
            break

    return result


begin_y = -1
begin_x = -1

for i in range(n):
    for j in range(m):
        if lst[i][j] == 2:
            begin_y = i
            begin_x = j

answer = bfs(begin_y, begin_x)

if answer == -1:
    print("NIE")
else:
    print("TAK")
    print(answer)