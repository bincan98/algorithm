"""
bfs 하는데 너비 하나만큼하고 왔는지 체크하기
visited에 너비와 그 너비에 도착한 경우의 수를 저장
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())


def bfs(start):
    q = deque()

    visited[start][0] = 0
    visited[start][1] = 1
    q.append([start, 0])

    while q:
        if visited[K][0] != -1:
            break
        size = len(q)
        for i in range(size):
            current, depth = q.popleft()
            if is_valid(current - 1):
                if visited[current - 1][0] == -1 or visited[current - 1][0] == (depth + 1):
                    visited[current - 1][0] = depth + 1
                    visited[current - 1][1] += 1
                    q.append([current - 1, depth + 1])
            if is_valid(current + 1):
                if visited[current + 1][0] == -1 or visited[current + 1][0] == (depth + 1):
                    visited[current + 1][0] = depth + 1
                    visited[current + 1][1] += 1
                    q.append([current + 1, depth + 1])
            if is_valid(current * 2):
                if visited[current * 2][0] == -1 or visited[current * 2][0] == (depth + 1):
                    visited[current * 2][0] = depth + 1
                    visited[current * 2][1] += 1
                    q.append([current * 2, depth + 1])


def is_valid(a):
    return 0 <= a < 200_001


visited = [[-1, 0] for _ in range(200_001)]

bfs(N)

print(visited[K][0])
print(visited[K][1])