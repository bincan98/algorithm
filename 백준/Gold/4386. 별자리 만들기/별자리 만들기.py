"""
MST 문제

각 별들이 모두 연결되어있는 그래프를 상정하고 가중치는 두 별사이의 거리이다

여기서 가중치가 최소인 MST를 만들면 끝
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = []
for _ in range(N):
    lst.append(list(map(float, input().split())))

edges = []
for i in range(N):
    for j in range(i):
        if i == j:
            continue
        edges.append([((lst[i][0] - lst[j][0]) ** 2 + (lst[i][1] - lst[j][1]) ** 2) ** 0.5, i, j])

edges = sorted(edges)

p = [i for i in range(N)]


def find(a):
    if p[a] == a:
        return a
    p[a] = find(p[a])
    return p[a]


def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    p[a] = b
    return True


cnt = 0
answer = 0
for dis, a, b in edges:
    if cnt == N - 1:
        break
    if union(a, b):
        cnt += 1
        answer += dis

print(f'{answer:.2f}')