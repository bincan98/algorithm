"""
조합으로 3가지 빈 칸에 벽을 랜덤하게 세우고
바이러스를 퍼뜨린뒤 안전영역을 answer에 넣어보기
"""

import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

dxy = [[0, 1], [0, -1], [1, 0], [-1, 0]]

N, M = map(int, input().split())

board = []
new_board = [[0] * M for _ in range(N)]

for i in range(N):
    board.append(list(map(int, input().split())))

ans = 0
selected = [[0, 0] for _ in range(3)]


def isValid(y, x):
    return 0 <= y < N and 0 <= x < M


def virus():
    q = deque()
    visited = [[False] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            new_board[i][j] = board[i][j]
            if board[i][j] == 2:
                q.append([i, j])
                visited[i][j] = True

    while q:
        cur_y, cur_x = q.popleft()
        for dy, dx in dxy:
            ny = cur_y + dy
            nx = cur_x + dx
            if isValid(ny, nx) and not visited[ny][nx] and new_board[ny][nx] == 0:
                new_board[ny][nx] = 2
                q.append([ny, nx])
                visited[ny][nx] = True


def cacul():
    result = 0
    for i in range(N):
        for j in range(M):
            if new_board[i][j] == 0:
                result += 1

    return result


# 2차원 조합 뽑기
def recur(cur, y, x):
    if cur == 3:
        # print(*selected)
        global ans
        
        # 고른 거 중 빈칸이 아닌게 있다면 다음 조합 살피러 가기
        for r, c in selected:
            if board[r][c] != 0:
                return

        for r, c in selected:
            board[r][c] = 1
        virus()
        ans = max(ans, cacul())
        for r, c in selected:
            board[r][c] = 0

        return
    if x == M:
        y += 1
        x = 0
    if y == N:
        return
    selected[cur][0] = y
    selected[cur][1] = x
    recur(cur + 1, y, x + 1)
    selected[cur][0] = 0
    selected[cur][1] = 0
    recur(cur, y, x + 1)


recur(0, 0, 0)
print(ans)