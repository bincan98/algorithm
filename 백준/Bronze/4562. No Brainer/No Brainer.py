"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

D = 0
P = 0
for _ in range(N):
    X, Y = map(int, input().split())

    if X >= Y:
        print("MMM BRAINS")
    else:
        print("NO BRAINS")