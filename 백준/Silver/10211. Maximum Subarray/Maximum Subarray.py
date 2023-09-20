"""
"""

import sys

input = lambda: sys.stdin.readline().strip()

T = int(input())

for _ in range(T):
    N = int(input())
    ls = [0] + list(map(int, input().split()))

    prefix_sum = [0] * (N+1)
    for i in range(1, N+1):
        prefix_sum[i] = prefix_sum[i-1] + ls[i]

    answer = -1_000_001
    for i in range(1, N + 1):
        for j in range(i, N + 1):
            answer = max(answer, prefix_sum[j] - prefix_sum[i-1])

    print(answer)