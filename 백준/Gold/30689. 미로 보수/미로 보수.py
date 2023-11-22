"""
양방향 그래프로 풀기

visited에는 몇번째로 방문했는지 적기 (idx)

dfs로 idx적으면서 들어가고 idx를 만나면
만난 idx ~ 지금 idx까지의 최소 구하기
그러려면 재귀할때 이제 만나는 애들을 전부 들고 다니기
(시간초과)

사이클 찾으면 list에 넣기
나중에 따로 list 돌면서 최솟값 구하기
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

sys.setrecursionlimit(10 ** 7)


def dfs(cur_y, cur_x, idx, count):
    visited[cur_y][cur_x][0] = count
    visited[cur_y][cur_x][1] = idx

    for dy, dx, cur_char in [[0, 1, 'R'], [1, 0, 'D'], [0, -1, 'L'], [-1, 0, 'U']]:
        ny = cur_y + dy
        nx = cur_x + dx
        if 0 <= ny < N and 0 <= nx < M:
            if cur_char == lst[cur_y][cur_x]:
                if visited[ny][nx][1] != -1:
                    if visited[ny][nx][0] == count:
                        cycle.append([ny, nx, cur_y, cur_x])
                else:
                    dfs(ny, nx, idx + 1, count)


def bfs(start_y, start_x, end_y, end_x, min_value):
    q = deque()
    q.append([start_y, start_x])

    while True:
        cur_y, cur_x = q.popleft()
        if cur_y == end_y and cur_x == end_x:
            return min_value
        for dy, dx, cur_char in [[0, 1, 'R'], [1, 0, 'D'], [0, -1, 'L'], [-1, 0, 'U']]:
            ny = cur_y + dy
            nx = cur_x + dx
            if 0 <= ny < N and 0 <= nx < M:
                if cur_char == lst[cur_y][cur_x]:
                    q.append([ny, nx])
                    min_value = min(min_value, cost[ny][nx])


N, M = map(int, input().split())
lst = [list(input()) for _ in range(N)]
cost = [list(map(int, input().split())) for _ in range(N)]
visited = [[[-1 for _ in range(2)] for _ in range(M)] for _ in range(N)]
cycle = []

answer = 0
cnt = 0
for i in range(N):
    for j in range(M):
        if visited[i][j][1] == -1:
            dfs(i, j, 0, cnt)
            cnt += 1

answer = 0
for start_y, start_x, end_y, end_x in cycle:
    answer += bfs(start_y, start_x, end_y, end_x, cost[start_y][start_x])
print(answer)