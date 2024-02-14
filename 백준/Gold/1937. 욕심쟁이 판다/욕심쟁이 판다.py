"""
그래프
대나무가 적은곳에서 많은곳으로 간선이 존재한다고 생각

완탐?
2500 * O(V(2500) + E(10000)) 시초

위상정렬?
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

dxy = [[-1, 0], [0, 1], [1, 0], [0, -1]]

n = int(input())
lst = []
for _ in range(n):
    lst.append(list(map(int, input().split())))

in_degree = [[0 for _ in range(n)] for _ in range(n)]
distance = [[-1 for _ in range(n)] for _ in range(n)]

q = deque()

# 차수 정리 & 차수가 0인 정점 큐에 삽입
for i in range(n):
    for j in range(n):
        cnt = 0
        for dy, dx in dxy:
            ny = i + dy
            nx = j + dx
            if 0 <= ny < n and 0 <= nx < n:
                if lst[ny][nx] < lst[i][j]:
                    cnt += 1
        in_degree[i][j] = cnt
        if cnt == 0:
            q.append((i, j))
            distance[i][j] = 1

# 큐 돌리기
while q:
    cur_y, cur_x = q.popleft()
    for dy, dx in dxy:
        ny = cur_y + dy
        nx = cur_x + dx
        if 0 <= ny < n and 0 <= nx < n:
            if lst[ny][nx] > lst[cur_y][cur_x]:
                in_degree[ny][nx] -= 1
                if in_degree[ny][nx] == 0:
                    distance[ny][nx] = distance[cur_y][cur_x] + 1
                    q.append((ny, nx))

answer = 0
for i in distance:
    answer = max(answer, max(i))

print(answer)