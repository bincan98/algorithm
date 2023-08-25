import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())

lst = dict()

for i in range(1, N+1):
    s = input()
    lst[str(i)] = s
    lst[s] = str(i)

for i in range(M):
    print(lst.get(input()))