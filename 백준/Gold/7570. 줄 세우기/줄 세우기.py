"""
관찰
5 2 4 1 3
2 다음에 3이 있으므로 2와 3은 움직이지 않았다
정렬되어 있는 숫자 개수 구하기
"""
import sys

sys.setrecursionlimit(10 ** 6)

input = lambda: sys.stdin.readline().strip()

n = int(input())
lst = list(map(int, input().split()))

start = [False] * (n + 1)
check = [i for i in range(n + 1)]

for a in lst:
    start[a] = True
    if a != 1:
        if start[a - 1]:
            check[a - 1] = a


def dfs(cur, cnt):
    if cur == check[cur]:
        global answer
        answer = max(answer, cnt)
        return
    visited[cur] = True
    dfs(check[cur], cnt + 1)


visited = [False] * (n + 1)
answer = 1
for i in range(1, n + 1):
    if visited[i]:
        continue
    if i == check[i]:
        visited[i] = True
        continue
    dfs(i, 1)

print(n - answer)