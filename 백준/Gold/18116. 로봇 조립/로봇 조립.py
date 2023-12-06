"""
기본 유파

부모 정보를 표현하는 p에 총 부품의 개수도 추가하기
"""
import sys

input = lambda: sys.stdin.readline().strip()

sys.setrecursionlimit(10 ** 6)


def find(a):
    # 리턴되는 값은 부품의 개수도 포함하는 리스트
    if p[a][0] == a:
        return p[a]
    p[a] = find(p[a][0])
    return p[a]


def union(a, b):
    list_a = find(a)
    list_b = find(b)
    # 이미 로봇이 조립되어 있다면 합치지 않기
    if list_a[0] == list_b[0]:
        return
    # 부품의 개수 더해주기
    p[list_b[0]][1] += p[list_a[0]][1]
    # 로봇 합치기
    p[list_a[0]][0] = list_b[0]
    # 부품의 개수를 먼저 더해주지 않으면 부품의 개수가 제대로 더해지지 않는다 (이미 포인터가 변해서)


n = int(input())

p = [[i, 1] for i in range(1_000_001)]

for i in range(n):
    lst = list(input().split())
    if lst[0] == 'I':
        union(int(lst[1]), int(lst[2]))
    else:
        parent = find(int(lst[1]))
        print(parent[1])