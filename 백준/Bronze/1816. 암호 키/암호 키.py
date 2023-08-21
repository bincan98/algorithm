"""
완전탐색

2부터 1_000_000까지 나누어서 나머지가 없으면 YES 아니라면 NO
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

for i in range(N):
    S = int(input())

    possible = True
    for i in range(2, 1_000_001):
        if S % i == 0:
            possible = False
            break

    if possible:
        print("YES")
    else:
        print("NO")