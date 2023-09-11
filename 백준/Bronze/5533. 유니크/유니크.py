"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

ls = []

for i in range(N):
    ls.append(list(map(int, input().split())))

answer = [0] * N

for i in range(3):
    for j in range(N):
        again = True
        for k in range(N):
            if j == k:
                continue
            if ls[j][i] == ls[k][i]:
                again = False
                break
        if again:
            answer[j] += ls[j][i]

for i in range(N):
    print(answer[i])