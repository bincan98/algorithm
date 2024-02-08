"""
bfs

+, -, 가능한 숫자버튼을 누르며 이동하는 번호까지
모두 간선이라고 생각하고 bfs 하기

틀림

visited를 false로 하니까 숫자버튼 1, 0, 1, 0 으로 갈 수 있는걸 101은 이미 +로 다녀와서 못가는걸로 처리됨
visited를 두개로 나눔 [0]은 채널을 +, - 해서 방문한 경우
[1]은 버튼을 눌러서 방문하는 경우
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N = int(input())
M = int(input())
lst = []
if M != 0:
    lst = list(map(int, input().split()))

if N == 100:
    print(0)
    exit()

arr = []
for i in range(10):
    if i not in lst:
        arr.append(i)

q = deque()
visited = [[False, False] for _ in range(1_000_000 + 1)]

q.append([99, 1, 0])
visited[99][0] = True
q.append([101, 1, 0])
visited[101][0] = True

for i in arr:
    q.append([i, 1, 1])
    visited[i][1] = True

answer = 0
while q:
    cur, dis, con = q.popleft()
    if cur == N:
        answer = dis
        break
    for d in [-1, 1]:
        nxt = cur + d
        if 0 <= nxt <= 1_000_000:
            if not visited[nxt][0]:
                q.append([nxt, dis + 1, 0])
                visited[nxt][0] = True
    if con == 1:
        for d in arr:
            nxt = cur * 10 + d
            if 0 <= nxt <= 1_000_000:
                if not visited[nxt][1]:
                    q.append([nxt, dis + 1, 1])
                    visited[nxt][1] = True

print(answer)