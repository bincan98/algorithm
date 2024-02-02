"""
bfs

벽 부수고 이동하기처럼 W * H * K 만큼 dis를 선언하자
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

dxy = [[-1, 0], [0, 1], [1, 0], [0, -1]]
dxy_knight = [[-2, -1], [-1, -2], [-2, 1], [-1, 2], [1, 2], [2, 1], [2, -1], [1, -2]]

K = int(input())
W, H = map(int, input().split())

dis = [[[-1 for _ in range(K + 1)] for _ in range(W)] for _ in range(H)]

lst = []
for _ in range(H):
    lst.append(list(map(int, input().split())))


def is_valid(y, x):
    return 0 <= y < H and 0 <= x < W


def bfs(start_y, start_x):
    global dis
    q = deque()

    q.append((start_y, start_x, 0, 0))
    dis[start_y][start_x][0] = 0

    while q:
        cur_y, cur_x, distance, cnt_k = q.popleft()
        for dy, dx in dxy:
            ny = cur_y + dy
            nx = cur_x + dx
            if is_valid(ny, nx) and lst[ny][nx] == 0 and dis[ny][nx][cnt_k] == -1:
                q.append((ny, nx, distance + 1, cnt_k))
                dis[ny][nx][cnt_k] = distance + 1
        if cnt_k == K:
            continue
        for dy, dx in dxy_knight:
            ny = cur_y + dy
            nx = cur_x + dx
            if is_valid(ny, nx) and lst[ny][nx] == 0 and dis[ny][nx][cnt_k + 1] == -1:
                q.append((ny, nx, distance + 1, cnt_k + 1))
                dis[ny][nx][cnt_k + 1] = distance + 1


bfs(0, 0)

if max(dis[H-1][W-1]) == -1:
    print(-1)
else:
    answer = 987654321
    for k in dis[H-1][W-1]:
        if k == -1:
            continue
        answer = min(answer, k)
    print(answer)