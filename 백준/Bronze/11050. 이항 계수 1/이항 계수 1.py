"""
"""

import sys

input = sys.stdin.readline

N, K = map(int, input().split())

if N == K or K == 0:
    print(1)
else:
    if K > N//2:
        K = N - K

    answer = 1

    for i in range(1, K+1):
        answer *= (N-(i-1))
        answer //= i

    print(answer)