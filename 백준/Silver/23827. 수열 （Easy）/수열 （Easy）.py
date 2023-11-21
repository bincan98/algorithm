"""
완탐은 터짐

dp 점화식 세움

dp[i] = dp[i-1] + sum(1...i-1) * lst[i]
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))
prefix_sum = [0] * N
prefix_sum[0] = lst[0]
dp = [0] * N

for i in range(1, N):
    prefix_sum[i] = lst[i] + prefix_sum[i-1]

for i in range(1, N):
    dp[i] = (dp[i-1] + prefix_sum[i-1] * lst[i]) % 1_000_000_007

print(dp[N-1])