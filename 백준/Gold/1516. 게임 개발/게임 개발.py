"""
위상 정렬

time 배열을 만들고 큐에 저장해가면서 갱신하기

틀림

https://www.acmicpc.net/board/view/120972

5
10 -1
20 1 -1
30 2 -1
40 3 5 -1
100 -1
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()


N = int(input())

in_degree = [0] * (N+1)
time = [0] * (N+1)
answer_time = [0] * (N+1)
graph = [[] for _ in range(N+1)]

for i in range(1, N+1):
    time[i], *lst = map(int, input().split())
    for j in range(N):
        if lst[j] == -1:
            break
        graph[lst[j]].append(i)
        in_degree[i] += 1

answer = []
q = deque()

for i in range(1, N+1):
    if in_degree[i] == 0:
        q.append((i, time[i]))
        answer_time[i] = time[i]

while q:
    cur, cur_time = q.popleft()
    answer.append(cur)

    for nxt in graph[cur]:
        in_degree[nxt] -= 1
        answer_time[nxt] = max(answer_time[nxt], cur_time + time[nxt])
        if in_degree[nxt] == 0:
            q.append((nxt, answer_time[nxt]))

for t in answer_time[1:]:
    print(t)