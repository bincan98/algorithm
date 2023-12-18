import sys

input = lambda: sys.stdin.readline().strip()

H, I, A, R, C = map(int, input().split())

print(H * I - A * R * C)