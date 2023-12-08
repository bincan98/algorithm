"""
MST

중량제한이 큰 다리부터 합치면서 두 공장이 연결 되었는지 체크하기

간선 리스트를 중량의 내림차순으로 정렬하기
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
        return
    if rnk[a] < rnk[b]:
        p[a] = b
    elif rnk[a] > rnk[b]:
        p[b] = a
    else:
        p[b] = a
        rnk[a] += 1


N, M = map(int, input().split())

p = [i for i in range(N + 1)]
rnk = [0 for i in range(N + 1)]

lst = sorted([list(map(int, input().split())) for _ in range(M)], key=lambda x: -x[-1])
factory_a, factory_b = map(int, input().split())

answer = 0
for A, B, C in lst:
    if find(factory_a) == find(factory_b):
        break
    union(A, B)
    answer = C

print(answer)