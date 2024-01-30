import sys

input = lambda: sys.stdin.readline().strip()

W, H = map(int, input().split())

print(W * H / 2)