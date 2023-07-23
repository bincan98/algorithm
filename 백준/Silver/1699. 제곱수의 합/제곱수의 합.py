"""
dp

dp[i] = i를 제곱수들의 합으로 표현할 때 그 항의 최소 개수

모든 수들은 제곱수들의 합으로 표현할 수 있다

1의 제곱 1이 i개 있으면 i를 나타낼 수 있음

따라서 dp[i]의 초기값은 i

100_000 보다 작은 제곱수들은 초기값이 1

제곱수들은 총 300에서 400개 남짓

for 문으로 1부터 N까지 증가시키면서

각 구한 제곱수들을 인덱스에 더하며 +1 한 값을 min으로 넣어보기
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

dp = [0] * (N+1)

square_num = []

for i in range(1, int(N ** 0.5) + 1):
    square_num.append(i * i)

for i in range(N+1):
    if i in square_num:
        dp[i] = 1
    else:
        dp[i] = i

for i in range(1, N+1):
    for sq in square_num:
        if i + sq > N:
            break
        dp[i+sq] = min(dp[i+sq], dp[i] + 1)

print(dp[N])