def solution(n):
    dp = [0] * 5_001

    dp[2] = 3
    dp[4] = 11

    sum = dp[2]
    for i in range(6, 5_001, 2):
        dp[i] = (sum * 2 + 2 + 3 * dp[i-2]) % 1_000_000_007
        sum += dp[i-2] % 1_000_000_007

    return dp[n]