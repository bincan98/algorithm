"""
dp

dp[i] = 가로 i x 세로 2인 직사각형을 채울 수 있는 방법의 수
"""

import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())

dp = [0] * 1001

dp[1] = 1
dp[2] = 2

for i in range(3, n+1):
    dp[i] = (dp[i-1] + dp[i-2]) % 10_007

print(dp[n])