"""
MST

크루스칼하기

일단 각자 자신의 논에 물을 대는것으로 하고 크루스칼 한다

간선의 비용이 작은것 부터 보되

각자 자신의 논에 물을 대는 비용과 간선을 연결하는 비용을 비교해서

작은 비용의 방법을 사용하자

4% 실패
자꾸 union 실패를 생각안하고 answer에 값을 추가해서 틀림
정신 차리자
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
    else:
        min_value = min(sz[a], sz[b])
        if rnk[a] < rnk[b]:
            p[a] = b
            sz[b] = min_value
        elif rnk[a] > rnk[b]:
            p[b] = a
            sz[a] = min_value
        else:
            p[b] = a
            rnk[a] += 1
            sz[a] = min_value
    return True


N = int(input())

p = [i for i in range(N + 1)]
rnk = [0 for i in range(N + 1)]

sz = [0]
for i in range(N):
    sz.append(int(input()))

lst = []
for i in range(N):
    lst.append(list(map(int, input().split())))

can_edge = []
for i in range(N):
    for j in range(i + 1, N):
        can_edge.append([i + 1, j + 1, lst[i][j]])

can_edge = sorted(can_edge, key=lambda x: x[-1])

answer = 0
for u, v, w in can_edge:
    a = find(u)
    b = find(v)
    # 작은쪽 우물과 연결하기
    con = min(sz[a], sz[b]) + w
    # 우물 그대로 두고 연결하지 않기
    sep = sz[a] + sz[b]
    if con < sep:
        if union(u, v):
            answer += w

# 남아 있는 우물 answer에 더해주기
for i in range(1, N+1):
    if i == p[i]:
        answer += sz[i]

print(answer)