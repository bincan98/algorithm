"""
기본적인 누적합 문제

패딩을 주면 편하다
"""

import sys

input = sys.stdin.readline

N, M = map(int, input().split())

lst = [0] + list(map(int, input().split()))

prefix_sum = [0] * (N+1)

for i in range(1, N+1):
    prefix_sum[i] = prefix_sum[i-1] + lst[i]

for _ in range(M):
    i, j = map(int, input().split())
    print(prefix_sum[j] - prefix_sum[i-1])