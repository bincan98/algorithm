"""
중복조합

(n + k - 1) C (k - 1)
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())

answer = 1
for i in range(1, K):
    answer *= (N + K - i)
    answer //= i

print(answer % 1_000_000_000)