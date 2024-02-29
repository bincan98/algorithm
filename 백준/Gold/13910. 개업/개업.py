"""
관찰
양 손으로 만들 수 있다
한 손으로도 만들 수 있다

그럼 양손으로 만들 수 있는 모든 경우의 수를 웍 리스트에 넣기

만들 수 있는 모든 웍 리스트로 bfs 하기
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())
wok = list(map(int, input().split()))

all_wok = wok[:]
for i in range(M):
    for j in range(i, M):
        if i == j:
            continue
        if wok[i] + wok[j] > N:
            continue
        all_wok.append(wok[i] + wok[j])

all_wok = sorted(all_wok)

visited = [-1] * (N + 1)
q = deque()

for w in all_wok:
    visited[w] = 1
    q.append(w)

while q:
    cur = q.popleft()
    for w in all_wok:
        if cur + w > N:
            break
        if visited[cur + w] == -1:
            q.append(cur + w)
            visited[cur + w] = visited[cur] + 1

print(visited[N])