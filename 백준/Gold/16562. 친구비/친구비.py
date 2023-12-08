"""
유니온 파인드

이 집합을 방문했는지 visited에 저장하기

연결요소 개수 구하기에서 사이즈 추가함

union 할 때 가장 작은값으로 동기화 시켜주기 
"""
import sys

input = lambda: sys.stdin.readline().strip()

sys.setrecursionlimit(10 ** 6)


def find(a):
    if p[a] == a:
        return p[a]
    p[a] = find(p[a])
    return p[a]


def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    if sz[a] > sz[b]:
        sz[a] = sz[b]
    else:
        sz[b] = sz[a]
    if rnk[a] < rnk[b]:
        p[a] = b
    elif rnk[a] > rnk[b]:
        p[b] = a
    else:
        p[b] = a
        rnk[a] += 1
    return True


N, M, k = map(int, input().split())

p = [i for i in range(N + 1)]
rnk = [0 for i in range(N + 1)]
visited = [False for _ in range(N + 1)]

sz = [0] + list(map(int, input().split()))

for i in range(M):
    u, v = map(int, input().split())
    union(u, v)

total = 0
for i in range(1, N + 1):
    x = find(i)
    if not visited[x]:
        total += sz[x]
        visited[x] = True

if total > k:
    print("Oh no")
else:
    print(total)