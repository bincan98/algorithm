"""
기본 MST

기본 크루스칼
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
    if rnk[a] < rnk[b]:
        p[a] = b
    elif rnk[a] > rnk[b]:
        p[b] = a
    else:
        p[b] = a
        rnk[a] += 1
    return True


N, M = map(int, input().split())

p = [i for i in range(N + 1)]
rnk = [0 for i in range(N + 1)]

lst = sorted([list(map(int, input().split())) for _ in range(M)], key=lambda x: x[-1])

answer = 0
cnt = 0
for A, B, C in lst:
    if cnt == N - 1:
        break
    if union(A, B):
        cnt += 1
        answer += C

print(answer)