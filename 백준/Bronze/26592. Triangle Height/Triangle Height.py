"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

for _ in range(N):
    a, b = map(float, input().split())
    print(f'The height of the triangle is {round(2 * a / b, 2):.2f} units')