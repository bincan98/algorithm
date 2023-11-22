import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())


def bfs(start):
    q = deque()

    visited[start] = 0
    q.append(start)

    while q:
        if visited[K] != -1:
            break
        current = q.popleft()
        if is_valid(current - 1):
            if visited[current - 1] == -1 or visited[current - 1] > visited[current] + 1:
                visited[current - 1] = visited[current] + 1
                q.append(current - 1)
        if is_valid(current + 1):
            if visited[current + 1] == -1 or visited[current + 1] > visited[current] + 1:
                visited[current + 1] = visited[current] + 1
                q.append(current + 1)
        if is_valid(current * 2):
            if visited[current * 2] == -1 or visited[current * 2] > visited[current] + 1:
                visited[current * 2] = visited[current] + 1
                q.append(current * 2)


def is_valid(a):
    return 0 <= a < 200_001


visited = [-1 for _ in range(200_001)]

bfs(N)

print(visited[K])