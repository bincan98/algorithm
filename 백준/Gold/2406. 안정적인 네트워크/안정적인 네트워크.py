"""
MST

안정적인 네트워크 조건을 만족하려면 모든 지사의 컴퓨터들이 연결되어 있어야 한다

모든 컴퓨터들은 본사의 컴퓨터와 연결이 되어있으므로 두 컴퓨터가 끊어져도 연결이 이어진다.
마찬가지로 한 컴퓨터가 고장나도 문제없이 연결될 수 있다.

1번을 제외한 컴퓨터들이 모두 연결되도록 MST 하기
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


n, m = map(int, input().split())

p = [i for i in range(n + 1)]
rnk = [0 for i in range(n + 1)]

total_cnt = 0
for i in range(m):
    x, y = map(int, input().split())
    if union(x, y):
        total_cnt += 1

lst = [[0] * (n + 1)]

for i in range(n):
    lst.append([0] + list(map(int, input().split())))

# 간선후보 만들기
can_edge = []
for i in range(2, n + 1): # 1번은 모두와 연결되어 있으므로 후보에 넣을 필요 없다
    for j in range(i + 1, n + 1):
        can_edge.append([i, j, lst[i][j]])

# 간선후보 정렬
can_edge = sorted(can_edge, key=lambda x: x[-1])

total = 0
answer_cnt = 0
answer = []
for a, b, c in can_edge:
    if total_cnt == n - 2:
        break
    if union(a, b):
        total += c
        answer_cnt += 1
        total_cnt += 1
        answer.append([a, b])

print(total, answer_cnt)
if total != 0:
    for i in answer:
        print(*i)