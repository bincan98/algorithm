"""
완전탐색

병사 조합으로 뽑기 100C50 시간초과

주어지는 병사들의 스탯으로 스탯을 결정하고 돌려보기

스탯결정 100^3
이길 수 있는 병사 세어보기 100

100^4 애매함
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())

lst = []
for _ in range(N):
    lst.append(list(map(int, input().split())))

answer = 3_000_000
for i in range(N):
    for j in range(N):
        for k in range(N):
            cnt = 0
            for l in range(N):
                if lst[i][0] >= lst[l][0] and lst[j][1] >= lst[l][1] and lst[k][2] >= lst[l][2]:
                    cnt += 1
            if cnt >= K:
                answer = min(answer, lst[i][0] + lst[j][1] + lst[k][2])

print(answer)