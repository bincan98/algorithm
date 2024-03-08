"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, W, H, L = map(int, input().split())

answer = 1
answer *= W // L
answer *= H // L

if answer > N:
    print(N)
else:
    print(answer)