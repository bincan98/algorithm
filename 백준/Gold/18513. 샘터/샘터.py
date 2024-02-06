"""
샘터에서 bfs 해나가기

메모리 초과
visited를 dict로
"""
import sys
from collections import deque
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())

lst = list(map(int, input().split()))

answer = 0

q = deque()

visited = defaultdict(bool)

for a in lst:
    q.append([a, 0])
    visited[a] = True

cnt = 0
answer = 0
ex = False
while q:
    cur, dis = q.popleft()
    for d in [-1, 1]:
        n = cur + d
        if -100_100_000 <= n <= 100_100_000:
            if not visited[n]:
                visited[n] = True
                q.append([n, dis + 1])
                answer += dis + 1
                cnt += 1
        if cnt == K:
            ex = True
            break
    if ex:
        break

print(answer)