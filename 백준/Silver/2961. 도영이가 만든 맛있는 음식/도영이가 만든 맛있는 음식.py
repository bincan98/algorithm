"""
모든 부분집합을 구해서 모든 경우의 수를 구해본다
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = []

for i in range(N):
    lst.append(list(map(int, input().split())))

answer = 1_000_000_000


def recur(cur, total_sour, total_biitter):
    if cur == N:
        if total_sour == 1 and total_biitter == 0:
            return
        else:
            global answer
            answer = min(answer, abs(total_sour - total_biitter))
            return
    recur(cur + 1, total_sour * lst[cur][0], total_biitter + lst[cur][1])
    recur(cur + 1, total_sour, total_biitter)


recur(0, 1, 0)

print(answer)