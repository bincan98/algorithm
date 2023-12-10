"""
MST

크루스칼하기

유니온 하기전에 두 도시가 발전소에 연결되었는지 확인한다

만약 두 도시가 모두 발전소에 연결되어있다면 넘어가기

모두 발전소에 연결되어 있지 않다면 둘 이 합치고 sz에 간선의 비용을 적어두기

하나가 연결되어 있다면 발전소 쪽으로 합치고 answer에 바라전소가 아닌쪽의 size와 이번 간선의 비용까지 더해주기

union이 되는 경우에만 w 더해주기
"""
import sys

input = lambda: sys.stdin.readline().strip()

sys.setrecursionlimit(10 ** 6)


def find(a):
    if p[a] == a:
        return p[a]
    p[a] = find(p[a])
    return p[a]


def union(a, b, w):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    if a in supply:
        p[b] = a
    elif b in supply:
        p[a] = b
    else:
        if rnk[a] < rnk[b]:
            p[a] = b
        elif rnk[a] > rnk[b]:
            p[b] = a
        else:
            p[b] = a
            rnk[a] += 1
    return True


N, M, K = map(int, input().split())

supply = list(map(int, input().split()))

p = [i for i in range(N + 1)]
rnk = [0 for i in range(N + 1)]

lst = []
for i in range(M):
    lst.append(list(map(int, input().split())))

lst = sorted(lst, key= lambda x: x[-1])

answer = 0
for u, v, w in lst:
    a = find(u)
    b = find(v)
    connected_u = False
    if a in supply:
        connected_u = True
    connected_v = False
    if b in supply:
        connected_v = True
    if connected_u and connected_v:
        continue
    else:
        if union(a, b, w):
            answer += w

print(answer)