import sys

input = lambda: sys.stdin.readline().strip()

_, _ = map(int, input().split())

a = int(input())
b = int(input())

print(a * b)