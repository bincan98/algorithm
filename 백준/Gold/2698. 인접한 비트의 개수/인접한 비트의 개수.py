"""
dp

dp[N][K][0] = 크기가 N이고 인접한 비트의 개수가 K이고 끝이 0인 수열의 개수
dp[N][K][1] = 크기가 N이고 인접한 비트의 개수가 K이고 끝이 1인 수열의 개수
dp[N][K][2] = 크기가 N이고 인접한 비트의 개수가 K인 수열의 개수

dp[5][2] = dp[5][2][0] + dp[5][2][1]
뒤에 0 붙이는 경우) dp[5][2][0] = dp[4][2][0] + dp[4][2][1]
뒤에 1 붙이는 경우) dp[5][2][1] = dp[4][1][1] + dp[4][2][0]

if dp[5][0] = dp[5][0][0] + dp[5][0][1]
dp[5][0][0] = dp[4][0][0] + dp[4][0][1]
dp[5][0][1] = dp[4][0][0]

만약 j 가 0이면 j-1은 빼기
"""
import sys

input = lambda: sys.stdin.readline().strip()

dp = [[[0, 0, 0] for _ in range(100)] for _ in range(101)]

dp[1][0][0] = 1
dp[1][0][1] = 1
dp[1][0][2] = dp[1][0][0] + dp[1][0][1]

dp[1][1][0] = 0
dp[1][1][1] = 0
dp[1][1][2] = dp[1][1][0] + dp[1][1][1]

for i in range(2, 101):
    for j in range(i):
        dp[i][j][0] = dp[i - 1][j][2]
        if j == 0:
            dp[i][j][1] = dp[i - 1][j][0]
        else:
            dp[i][j][1] = dp[i - 1][j - 1][1] + dp[i - 1][j][0]
        dp[i][j][2] = dp[i][j][0] + dp[i][j][1]

for _ in range(int(input())):
    N, K = map(int, input().split())
    print(dp[N][K][2])