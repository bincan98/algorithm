import sys

input = lambda: sys.stdin.readline().strip()

lst = list(map(int, input().split()))

piece = [1, 1, 2, 2, 2, 8]

for i in range(6):
    print(piece[i] - lst[i], end=" ")