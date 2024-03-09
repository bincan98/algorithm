"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

L = int(input())
A = int(input())
B = int(input())
C = int(input())
D = int(input())

day = 0
if A % C == 0:
    day = max(day, A // C)
else:
    day = max(day, A // C + 1)

if B % D == 0:
    day = max(day, B // D)
else:
    day = max(day, B // D + 1)

print(L - day)