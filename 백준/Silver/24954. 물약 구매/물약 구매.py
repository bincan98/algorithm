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


def disco(arr, cur):
    new_lst = arr[:]
    result = 0
    result += new_lst[selected[cur]]
    for dis in discount[selected[cur]]:
        new_lst[dis[0]] -= dis[1]
        if new_lst[dis[0]] <= 0:
            new_lst[dis[0]] = 1
    return new_lst


def recur(cur, total, arr):
    global answer
    if total > answer:
        return
    if cur == N:
        # print(selected)
        # new_lst = lst[:]
        # result = 0
        # for a in selected:
        #     result += new_lst[a]
        #     for dis in discount[a]:
        #         new_lst[dis[0]] -= dis[1]
        #         if new_lst[dis[0]] <= 0:
        #             new_lst[dis[0]] = 1
        answer = min(answer, total)
        return
    for i in range(1, N+1):
        if visited[i]:
            continue
        visited[i] = True
        selected[cur] = i
        recur(cur + 1, total + arr[i], disco(arr, cur))
        visited[i] = False


recur(0, 0, lst)
print(answer)