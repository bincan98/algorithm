"""
dp?

dp[a][b] = a부터 b까지 구간의 곱셈 연산 최솟값
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = []
for _ in range(N):
    lst.append(list(map(int, input().split())))

dp = [[0 for _ in range(N)] for _ in range(N)]


def recur(a, b):
    if a == b:
        return 0
    if dp[a][b] != 0:
        return dp[a][b]
    dp[a][b] = 9876543210
    for i in range(a, b):
        x = recur(a, i)
        y = recur(i + 1, b)
        z = lst[a][0] * lst[i][1] * lst[b][1]
        dp[a][b] = min(dp[a][b], x + y + z)
    return dp[a][b]


print(recur(0, N - 1))