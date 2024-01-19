"""
위상 정렬

각 순위가 가지는 선후관계를 모두 간선으로 정의
그리고 바뀌는 순위는 간선 뒤집기

만약 answer의 원소의 개수가 N이 아니라면 불가능한경우
pq의 우선순위를 다르게할경우 answer 리스트의 값이 달라지면 ? 출력하기
"""
import sys
import heapq

input = lambda: sys.stdin.readline().strip()

T = int(input())

for _ in range(T):
    N = int(input())
    lst = list(map(int, input().split()))

    in_degree = [0] * (N+1)
    graph = [[False for _ in range(N+1)] for _ in range(N+1)]

    for i in range(N):
        for j in range(i + 1, N):
            in_degree[lst[j]] += 1
            graph[lst[i]][lst[j]] = True

    M = int(input())
    for i in range(M):
        a, b = map(int, input().split())
        if graph[a][b]:
            graph[a][b] = False
            graph[b][a] = True
            in_degree[b] -= 1
            in_degree[a] += 1
        else:
            graph[a][b] = True
            graph[b][a] = False
            in_degree[b] += 1
            in_degree[a] -= 1

    new_in_degree = in_degree[:]
    answer = []
    pq = []
    for i in range(1, N+1):
        if in_degree[i] == 0:
            heapq.heappush(pq, i)

    while pq:
        cur = heapq.heappop(pq)
        answer.append(cur)

        for nxt in range(1, N+1):
            if graph[nxt]:
                in_degree[nxt] -= 1
                if in_degree[nxt] == 0:
                    heapq.heappush(pq, nxt)

    if len(answer) != N:
        print("IMPOSSIBLE")
        continue

    in_degree = new_in_degree[:]
    answer2 = []
    pq = []
    for i in range(1, N + 1):
        if in_degree[i] == 0:
            heapq.heappush(pq, -i)

    while pq:
        cur = -heapq.heappop(pq)
        answer2.append(cur)

        for nxt in range(1, N + 1):
            if graph[nxt]:
                in_degree[nxt] -= 1
                if in_degree[nxt] == 0:
                    heapq.heappush(pq, -nxt)

    if answer == answer2:
        print(*answer)
    else:
        print("?")