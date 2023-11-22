"""
bfs 하는데 너비 하나만큼하고 왔는지 체크하기
visited에 너비(걸린 시간) 저장

큐에 넣을떄 그전의 값들 저장해두기 (시간 초과)

그럼 visited에 그전 값을 저장해두기
[0]은 너비 [1]은 그전 값
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())


def bfs(start):
    q = deque()

    visited[start][0] = 0
    q.append(start)

    while q:
        if visited[K][0] != -1:
            break
        current = q.popleft()
        if is_valid(current - 1):
            if visited[current - 1][0] == -1:
                visited[current - 1][0] = visited[current][0] + 1
                visited[current - 1][1] = current
                q.append(current - 1)
        if is_valid(current + 1):
            if visited[current + 1][0] == -1:
                visited[current + 1][0] = visited[current][0] + 1
                visited[current + 1][1] = current
                q.append(current + 1)
        if is_valid(current * 2):
            if visited[current * 2][0] == -1:
                visited[current * 2][0] = visited[current][0] + 1
                visited[current * 2][1] = current
                q.append(current * 2)


def is_valid(a):
    return 0 <= a < 200_001


visited = [[-1, -1] for _ in range(200_001)]

bfs(N)

cur = K
answer = [K]
while True:
    if cur == N:
        break
    answer.append(visited[cur][1])
    cur = visited[cur][1]

print(visited[K][0])
print(*answer[::-1])