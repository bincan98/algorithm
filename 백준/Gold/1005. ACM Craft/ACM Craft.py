"""
위상 정렬

time 배열을 만들고 큐에 저장해가면서 갱신하기

https://www.acmicpc.net/problem/1516
과 비슷
"""
import sys
from collections import deque

input = lambda: sys.stdin.readline().strip()


T = int(input())

for _ in range(T):
    N, K = map(int, input().split())

    in_degree = [0] * (N+1)
    answer_time = [0] * (N+1)
    graph = [[] for _ in range(N+1)]

    time = [0] + list(map(int, input().split()))

    for _ in range(K):
        a, b = map(int, input().split())
        graph[a].append(b)
        in_degree[b] += 1

    W = int(input())
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

    print(answer_time[W])