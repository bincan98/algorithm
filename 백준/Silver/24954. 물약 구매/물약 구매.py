"""
순열 10!이어서 가능

그리고 매번 할인
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = [0] + list(map(int, input().split()))

discount = [[]]
for i in range(N):
    c = int(input())
    ls = []
    for j in range(c):
        ls.append(list(map(int, input().split())))
    discount.append(ls)

visited = [False] * (N + 1)
selected = [0] * N
answer = 987654321


def recur(cur):
    if cur == N:
        # print(selected)
        global answer
        new_lst = lst[:]
        result = 0
        for a in selected:
            result += new_lst[a]
            for dis in discount[a]:
                new_lst[dis[0]] -= dis[1]
                if new_lst[dis[0]] <= 0:
                    new_lst[dis[0]] = 1
        answer = min(answer, result)
        return
    for i in range(1, N+1):
        if visited[i]:
            continue
        visited[i] = True
        selected[cur] = i
        recur(cur + 1)
        visited[i] = False


recur(0)
print(answer)