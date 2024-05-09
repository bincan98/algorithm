"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
F = int(input())

for i in range(10):
    for j in range(10):
        N //= 100
        N *= 100
        N += 10 * i
        N += j
        if N % F == 0:
            print(f'{i}{j}')
            exit(0)