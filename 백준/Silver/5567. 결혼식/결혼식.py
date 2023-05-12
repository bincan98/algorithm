import sys
from collections import deque

input = lambda : sys.stdin.readline().strip()

n = int(input())
m = int(input())

adjList = [[] for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    adjList[a].append(b)
    adjList[b].append(a)

visited = [False] * (n+1)

def bfs():
    q = deque()

    q.append(1)
    visited[1] = True

    result = 0
    cnt = 0
    while q:
        if cnt >= 2:
            break
        cnt += 1
        size = len(q)
        for _ in range(size):
            cur = q.popleft()
            for nxt in adjList[cur]:
                if not visited[nxt]:
                    q.append(nxt)
                    visited[nxt] = True
                    result += 1
    return result

print(bfs())