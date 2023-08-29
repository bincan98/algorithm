"""
백트래킹으로 7명 뽑기

그렇게 뽑은 7명이 임도연파가 4명이 넘는 다면 return

만족한다면 연결요소를 검증하기

만족한다면 answer++
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
lst = []

for i in range(5):
    lst.append(input())

selected = [[-1, -1] for _ in range(7)]

answer = 0


def is_valid(y, x):
    return 0 <= y < 5 and 0 <= x < 5


cnt = 0


def bfs(start_y, start_x, visited_a):
    q = deque()
    q.append([start_y, start_x])

    while q:
        cur_y, cur_x = q.popleft()
        for i in range(4):
            ny = cur_y + dy[i]
            nx = cur_x + dx[i]
            for j in range(7):
                if not visited_a[j]:
                    if selected[j][0] == ny and selected[j][1] == nx:
                        visited_a[j] = True
                        q.append([ny, nx])
    return


def recur(cur, y, x, y_total, s_total):
    global cnt
    if y_total >= 4:
        return
    if cur == 7:
        visited_a = [False] * 7
        visited_a[0] = True
        bfs(selected[0][0], selected[0][1], visited_a)
        for i in range(7):
            if not visited_a[i]:
                return
        cnt += 1
        return
    if x == 5:
        x = 0
        y += 1
    if y == 5:
        return
    selected[cur] = [y, x]
    if lst[y][x] == 'S':
        recur(cur + 1, y, x + 1, y_total, s_total + 1)
    else:
        recur(cur + 1, y, x + 1, y_total + 1, s_total)
    selected[cur] = [-1, -1]
    recur(cur, y, x + 1, y_total, s_total)


recur(0, 0, 0, 0, 0)

print(cnt)