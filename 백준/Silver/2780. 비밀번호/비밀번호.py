"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

T = int(input())

dp = [0] * 1001
end_digit = [[0 for _ in range(10)] for _ in range(1001)]

end_digit[1] = [1 for _ in range(10)]
dp[1] = 10

for i in range(2, 1001):
    dp[i] += (end_digit[i - 1][0] + end_digit[i - 1][1] * 2 + end_digit[i - 1][2] * 3
              + end_digit[i - 1][3] * 2 + end_digit[i - 1][4] * 3 + end_digit[i - 1][5] * 4
              + end_digit[i - 1][6] * 3 + end_digit[i - 1][7] * 3 + end_digit[i - 1][8] * 3
              + end_digit[i - 1][9] * 2) % 1_234_567

    end_digit[i][0] += (end_digit[i - 1][7]) % 1_234_567
    end_digit[i][1] += (end_digit[i - 1][2] + end_digit[i - 1][4]) % 1_234_567
    end_digit[i][2] += (end_digit[i - 1][1] + end_digit[i - 1][3] + end_digit[i - 1][5]) % 1_234_567
    end_digit[i][3] += (end_digit[i - 1][2] + end_digit[i - 1][6]) % 1_234_567
    end_digit[i][4] += (end_digit[i - 1][1] + end_digit[i - 1][5] + end_digit[i - 1][7]) % 1_234_567
    end_digit[i][5] += (end_digit[i - 1][2] + end_digit[i - 1][4] + end_digit[i - 1][6] + end_digit[i - 1][8]) % 1_234_567
    end_digit[i][6] += (end_digit[i - 1][3] + end_digit[i - 1][5] + end_digit[i - 1][9]) % 1_234_567
    end_digit[i][7] += (end_digit[i - 1][0] + end_digit[i - 1][4] + end_digit[i - 1][8]) % 1_234_567
    end_digit[i][8] += (end_digit[i - 1][5] + end_digit[i - 1][7] + end_digit[i - 1][9]) % 1_234_567
    end_digit[i][9] += (end_digit[i - 1][6] + end_digit[i - 1][8]) % 1_234_567

for _ in range(T):
    print(dp[int(input())])