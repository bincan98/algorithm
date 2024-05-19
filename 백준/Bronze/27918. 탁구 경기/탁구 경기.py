"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

D = 0
P = 0
for _ in range(N):
    s = input()
    if s == 'D':
        D += 1
    else:
        P += 1
    if abs(D - P) == 2:
        break

print(f'{D}:{P}')