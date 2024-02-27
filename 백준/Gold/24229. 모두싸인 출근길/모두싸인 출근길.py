"""
1. 이을 수 있는 판자는 모두 잇기
2. 판자마다 최대한 멀리 갈 수 있는 지점 찾기
3. 어떤 판자에서 시작했을 때 그 판자에서 최대한 멀리 갈 수 있는 지점보다 시작 점이 작은 판자들에서 또 최대한 멀리 갈 수 있는 판자들 구하기

틀림
합친 판자가 하나인 경우도 생각해야함

멀리까지 갈 수 있다고 해서 그게 답은 아닐 수 있음
"""
import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
lst = []
for _ in range(n):
    lst.append(list(map(int, input().split())))

lst = sorted(lst)
# 판자 합치기
lst_com = []
visited = [False] * n
for i in range(n):
    if visited[i]:
        continue
    start = lst[i][0]
    end = lst[i][1]
    for j in range(1, n):
        if i + j >= n:
            break
        if lst[i + j][0] <= end:
            visited[i + j] = True
            if end < lst[i + j][1]:
                end = lst[i + j][1]
        else:
            break
    lst_com.append([start, end, end - start + end])

answer = lst_com[0][1]
max_dis = lst_com[0][2]
for i in range(1, len(lst_com)):
    if lst_com[i][0] <= max_dis:
        max_dis = max(max_dis, lst_com[i][2])
        answer = max(answer, lst_com[i][1])

print(answer)